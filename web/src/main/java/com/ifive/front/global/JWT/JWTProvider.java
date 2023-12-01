package com.ifive.front.global.JWT;

import java.util.Base64;
import java.util.Date;
import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.security.core.Authentication;

import com.ifive.front.domain.Member.IfiveMemberSecurityServiceImpl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.annotation.PostConstruct;

// JWT 토큰 생성 및 분석
@Component // 컴포넌트 등록으로 다른 클래스에서 주입받기가능.
public class JWTProvider {
    public static String httpHeaderKey = "Authorization"; //http header에 담을 키값.
    private String secretKey = "myJWTKey";
    private long tokenExpireTime = 60 * 60 * 1000L; // 토큰 유효시간 : 60분

    private final IfiveMemberSecurityServiceImpl IfiveMemberSecurityService;

    public JWTProvider(IfiveMemberSecurityServiceImpl IfiveMemberSecurityService){
    	this.IfiveMemberSecurityService = IfiveMemberSecurityService;
    }

    // secretKey Base64로 인코딩
    @PostConstruct
    protected void secretKeyEncoding() {
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    // JWT 토큰 생성, 로그인 성공시 토큰 값 전달
    public String createJWT(String userPk, List<String> roles) {
        Claims claims = Jwts.claims().setSubject(userPk); // JWT payload 에 저장되는 정보단위, 보통 여기서 user를 식별하는 값을 넣는다.
        claims.put("roles", roles); // 정보는 key / value 쌍으로 저장된다.
        Date now = new Date();
        return Jwts.builder()
                .setClaims(claims) // 정보 저장
                .setIssuedAt(now) // 토큰 발행 시간
                .setExpiration(new Date(now.getTime() + tokenExpireTime)) // 만료시간
                .signWith(SignatureAlgorithm.HS256, secretKey) // 사용할 암호화 알고리즘과 signature 에 들어갈 secret값 세팅
                .compact();
    }

    // 권한조회, JWT 토큰에서 인증 정보 조회
    public Authentication permissionCheck(String token) {
        // 토큰에서 checkUser(String token)를 통해 사용자 name 가져옴. 
        UserDetails userDetails = IfiveMemberSecurityService.loadUserByUsername(this.checkUser(token));
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    // 토큰조회, 토큰의 유효성 + 만료일자 확인
    public boolean tokenCheck(String jwtToken) {
        try {
            Jws<Claims> claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(jwtToken);
            System.out.println(claims);
            return !claims.getBody().getExpiration().before(new Date());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // 토큰에서 회원 정보 추출
    private String checkUser(String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
    }
}