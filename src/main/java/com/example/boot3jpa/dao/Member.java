package com.example.boot3jpa.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "member")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity //
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //
    @Column
    private Long id; // DB 테이블의 'id' 와 매칭

    @Column(name = "name", nullable = false)
    private String name; // DB 테이블의 'name' 컬럼과 매칭


}
