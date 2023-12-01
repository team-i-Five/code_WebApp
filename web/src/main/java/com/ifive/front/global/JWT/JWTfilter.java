package com.ifive.front.global.JWT;


import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;


// 사용자의 요청 검증, 가로채는 클래스, 필터형태의 클래스(컨트롤러단 전에 작동)
// SpringSecurity는 Session으로 로그인 검증을 하는데, 이걸 JWT로 바꿔주기위해 필터클래스를 만듬 
@Component
public class JWTfilter extends GenericFilterBean {
	
	private JWTProvider provider;
	
	public JWTfilter(JWTProvider provider) {
		this.provider = provider;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String token = ((HttpServletRequest) request).getHeader(provider.httpHeaderKey);
        //유효한 토큰인지 확인합니다.
        if (token != null && provider.tokenCheck(token)) {
            // 토큰이 유효하면 토큰으로부터 유저 정보를 받아옵니다.
            Authentication authentication = provider.permissionCheck(token);
            //SecurityContext 에 Authentication 객체를 저장합니다.
            SecurityContextHolder.getContext().setAuthentication(authentication);
            System.out.println(authentication);
        }
        chain.doFilter(request, response);
	}

}