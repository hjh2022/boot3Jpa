package com.example.boot3jpa.config;

import com.example.boot3jpa.service.UserDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@RequiredArgsConstructor
@Configuration
public class WebSecurityConfig {
    private final UserDetailService userDetailService;

    // 스프링 시큐리티 기능 비활성화(모든 기능을 사용하지 않게 설정하는 것, 즉 모든곳에 적용 X)
    @Bean
    public WebSecurityCustomizer configure(){
        return (web) -> web.ignoring()
                .requestMatchers("/static/**");// 정적 리소스에는 스프링시큐리티를 비홯성화 한다.
    }

    // 특정 http 요청에 대한 웹 기반 보안 구성
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeRequests()// 인증, 인가 설정
                .requestMatchers("/login", "/signup", "/user").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin() // 폼 기반 로그인 설정
                .loginPage("/login")// 로그인페이지 경로를 설정한다.
                .defaultSuccessUrl("/articles")// 로그인이 완료되었을 때 이동할 경로를 설정합니다.
                .and()
                .logout()// 로그아웃 설정
                .logoutSuccessUrl("/login")
                .invalidateHttpSession(true)
                .and()
                .csrf().disable() // csrf 비활성화, csrf 공격을 방지하기 위해서는 활성화하는게 좋지만 실습을 편리하게 하기 위해 비활성해 해둔다.
                .build();
    }

    //인증 관리자 관련 설, 사용자 정보를 가져올 서비스를 재정의하거나, 인증방법, 예를 들어 LDAP, JDBC 기반 인증 등을 설정할 때 사용합니다.
    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http,
                                                       BCryptPasswordEncoder bCryptPasswordEncoder, UserDetailService userDetailService) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                // 사용자 정보 서비스 설정
                .userDetailsService(userDetailService) // 사용자정보를 가져올 서비스를 서비스설정 한다. 이때 설정하는 서비스는 UserDetailsService 를 상속받아야 한다.
                .passwordEncoder(bCryptPasswordEncoder)// 비밀번호를 암호화하기 위한 인코더를 설정 한다.
                .and()
                .build();
    }

    // 패스워드 인코더로 사용할 빈 등록
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
