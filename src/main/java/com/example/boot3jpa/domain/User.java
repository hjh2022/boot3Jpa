package com.example.boot3jpa.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class User implements UserDetails {
    /**
     * UserDetails 클래스는 스프링 시큐리티에서 사용자의 인증 정보를 담아두는 인터페이스 입니다.
     * 스프링 시큐리티에서 해당 객체를 통해 인증 정보를 가져오므로 필수 오버라이드 메서드가 있습니다.
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @Builder
    public User(String email, String password, String auth){
        this.email = email;
        this.password = password;
    }

    // 권한 반환
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("user"));
    }

    // 사용자의 패스워드를 반환
    @Override
    public String getPassword() {
        return null;
    }
    //사용자의 id를 반환(고유한값)
    @Override
    public String getUsername() {
        return null;
    }

    // 계정 만료 여부 반환
    @Override
    public boolean isAccountNonExpired() {
        return false;
    }
    // 계정 잠금 여부 반환
    @Override
    public boolean isAccountNonLocked() {
        return false;
    }
    // 패스워드의 만료 여부 반환
    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }
    // 계정 사용 가능 여부 반환
    @Override
    public boolean isEnabled() {
        // 계정이 사용 가능한지 확인하는 로직
        return false; // true -> 사용 가능
    }
}
