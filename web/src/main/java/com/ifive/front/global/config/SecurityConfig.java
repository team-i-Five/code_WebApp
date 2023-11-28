package com.ifive.front.global.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity // 모든 URL이 시큐리티 제어를 받음.
public class SecurityConfig {
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests((authorizeHttpRequests) -> authorizeHttpRequests
                .requestMatchers(new AntPathRequestMatcher("/**")).permitAll()) // 모든 인증되지않은 요청허락, 로그인없이도 접근가능
            //.csrf((csrf) -> csrf.ignoringRequestMatchers(new AntPathRequestMatcher(h2경로)), 우리는 Workbench를 쓰기에 필요없음
            .headers((headers) -> headers.addHeaderWriter(new XFrameOptionsHeaderWriter(
                XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN))); // 클릭재킹(CSRF) 공격방지, 다른사이트에서 프레임으로 포함 불가

        return http.build();
    }

    @Bean // 이제 다른곳에서 주입받아서 사용할 수 있다.
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    } 
}