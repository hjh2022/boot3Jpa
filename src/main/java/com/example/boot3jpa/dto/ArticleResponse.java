package com.example.boot3jpa.dto;

import com.example.boot3jpa.dao.Article;
import lombok.Builder;
import lombok.Getter;

@Getter
public class ArticleResponse {
    private final String title;
    private final String content;

    @Builder
    public ArticleResponse(Article article){
        this.title = article.getTitle();
        this.content = article.getContent();
    }
}
