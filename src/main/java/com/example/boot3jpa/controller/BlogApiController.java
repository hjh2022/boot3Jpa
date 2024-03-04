package com.example.boot3jpa.controller;

import com.example.boot3jpa.dao.Article;
import com.example.boot3jpa.dto.AddArticleRequest;
import com.example.boot3jpa.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class BlogApiController {
    private final BlogService blogService;

    @PostMapping("/api/articles")
    public ResponseEntity addArticle(@RequestBody AddArticleRequest request){
       Article article = blogService.save(request);
       return ResponseEntity.status(HttpStatus.CREATED) // 201
               .body(article);
    }
}
