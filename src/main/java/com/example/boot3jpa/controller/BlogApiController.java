package com.example.boot3jpa.controller;

import com.example.boot3jpa.dao.Article;
import com.example.boot3jpa.dto.AddArticleRequest;
import com.example.boot3jpa.dto.ArticleResponse;
import com.example.boot3jpa.dto.UpdateArticleRequest;
import com.example.boot3jpa.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/api/articles")
    public ResponseEntity getAll(){
        List<ArticleResponse> articles = blogService.getList()
                .stream()
                .map(ArticleResponse::new)
                .toList();

        return ResponseEntity.status(HttpStatus.OK)
                .body(articles);
    }

    @GetMapping("/api/articles/{id}")
    public ResponseEntity getOneContent(@PathVariable Long id){
       Article article = blogService.getOne(id);

       return ResponseEntity.status(HttpStatus.OK)
               .body(new ArticleResponse(article));
    }

    @DeleteMapping("/api/articles/{id}")
    public ResponseEntity deleteOne(@PathVariable Long id){
        blogService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/api/articles/{id}")
    public ResponseEntity updateOne(@PathVariable Long id,
                                    @RequestBody UpdateArticleRequest request){
       Article updatedArticle = blogService.update(id, request);
       return ResponseEntity.ok()
               .body(updatedArticle);
    }
}
