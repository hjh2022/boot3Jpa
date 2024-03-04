package com.example.boot3jpa.repository;

import com.example.boot3jpa.dao.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article, Long> {
}
