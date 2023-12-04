package com.ifive.front.global.config;

import java.util.stream.Collectors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.ifive.front.domain.Member.IfiveMemberSecurityServiceImpl;
import com.ifive.front.global.JWT.JWTProvider;
import com.ifive.front.global.JWT.JWTfilter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@EnableWebSecurity // 모든 URL이 시큐리티 제어를 받음. Spring Security 설정 클래스
public class SecurityConfig {

    IfiveMemberSecurityServiceImpl ifiveMemberSecurityServiceImpl;
    JWTfilter jwtFilter;
    JWTProvider jwtProvider;

    public SecurityConfig(IfiveMemberSecurityServiceImpl ifiveMemberSecurityServiceImpl, JWTfilter jwtFilter,
            JWTProvider jwtProvider) {
        this.jwtFilter = jwtFilter;
        this.jwtProvider = jwtProvider;
        this.ifiveMemberSecurityServiceImpl = ifiveMemberSecurityServiceImpl;
    }

    // *** 시큐리티 세션을 이용한 로그인처리
    // @Bean
    // SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    // http.authorizeHttpRequests((authorizeHttpRequests) -> authorizeHttpRequests
    // .requestMatchers(new AntPathRequestMatcher("/**")).permitAll()); // 모든 인증되지않은
    // 요청허락, 로그인없이도 접근가능

    // http.headers((headers) -> headers.addHeaderWriter(new
    // XFrameOptionsHeaderWriter(
    // XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN))); // 클릭재킹(CSRF)
    // 공격방지, 다른사이트에서 프레임으로 포함 불가

    // http.formLogin((formLogin) -> formLogin
    // .loginPage("/member/signin") // 로그인 페이지 URL설정
    // .defaultSuccessUrl("/") // 로그인 성공시 이동할 URL설정
    // .usernameParameter("memberName"));

    // http.logout((logout) -> logout
    // .logoutRequestMatcher(new AntPathRequestMatcher("/member/signout"))
    // .logoutSuccessUrl("/")
    // .invalidateHttpSession(true));

    // return http.build();
    // }

    // *** JWT을 이용한 로그인처리
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
            .authorizeHttpRequests((authorizeHttpRequests) -> authorizeHttpRequests
                .requestMatchers(new AntPathRequestMatcher("/**")).permitAll()); // 모든 인증되지않은 요청허락, 로그인없이도 접근가능

        http.headers((headers) -> headers.addHeaderWriter(new XFrameOptionsHeaderWriter(
                XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN))); // 클릭재킹(CSRF) 공격방지, 다른사이트에서 프레임으로 포함 불가

        // 스프링 세션 필터대신 JWT토큰 필터를 사용
        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        http.formLogin((formLogin) -> formLogin
                .loginPage("/member/signin") // 로그인 페이지 URL설정
                .usernameParameter("memberName")
                .successHandler((request, response, auth) -> { // 로그인 성공시 행동을 정의 합니다.
                    String ip = request.getRemoteAddr();
                    String user_id = auth.getName();

                    log.info("login ok : {} + id: {}", ip, user_id);

                    response.setCharacterEncoding("UTF-8");
                    response.setHeader("Content-Type", "application/download; UTF-8");
                    String token = jwtProvider.createJWT(user_id,
                            auth.getAuthorities().stream().map(arg -> arg.getAuthority()).collect(Collectors.toList()));
                    response.getWriter().write("{\"result\" : \"" + token + "\" }");
                })
                .failureHandler((request, response, auth) -> { // 로그인 실패시 행동을 정의 합니다.
                    String ip = request.getRemoteAddr();
                    String user_id = request.getParameter("username");

                    log.info("login fail : {} user : {}", ip, user_id);

                    response.sendRedirect("/");
                }));

        http.logout((logout) -> logout
                .logoutRequestMatcher(new AntPathRequestMatcher("/member/signout"))
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true));

        return http.build();
    }

    @Bean // 패스워드 암호화 빈
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // AuthenticationManager는 스프링 시큐리티 인증 담당함.
    // AuthenticationManager의 사용자 인증은 IfiveMemberSecurityService와 PasswordEncoder를
    // 사용함
    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
            throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

}