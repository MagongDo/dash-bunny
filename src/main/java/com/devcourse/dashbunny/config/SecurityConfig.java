//package com.devcourse.dashbunny.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests(auth -> auth
//                        .anyRequest().permitAll() // 모든 요청 허용
//                )
//                .csrf(csrf -> csrf.disable()); // CSRF 비활성화 (H2 콘솔에서 필요)
//
//        return http.build();
//    }
//}
//
