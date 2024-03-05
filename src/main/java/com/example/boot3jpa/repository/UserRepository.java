package com.example.boot3jpa.repository;

import com.example.boot3jpa.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);// email 로 사용자 정보를 가져옴 | JPA 는 메서드 규칙에 맞춰 메서드를 선언하면 이름을 분석해 자동으로 쿼리를 생성해준다.
    /**
     * Select * From users Where email = #{email} 쿼리를 요청한다.
     */

}
