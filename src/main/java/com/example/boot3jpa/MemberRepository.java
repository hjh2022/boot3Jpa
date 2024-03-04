package com.example.boot3jpa;

import com.example.boot3jpa.dao.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    /**
     * Member 는 관리할 엔티티이름
     * Long 은 엔티티 기본키의 타입
     */
}
