package com.example.boot3jpa.dao;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "article")
@NoArgsConstructor
@Getter
@Entity //
public class Article {
    @Id // id 필드를 기본키로 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키 자동 1씩 증가
    @Column
    private Long id; // DB 테이블의 'id' 와 매칭

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @Builder // 빌더패턴으로 객체생성 가능하게 된다.
    public Article(String title, String content){
        this.title = title;
        this.content = content;
    }
    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}
