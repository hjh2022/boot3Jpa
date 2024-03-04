package com.example.boot3jpa.service;

import com.example.boot3jpa.dao.Article;
import com.example.boot3jpa.dto.AddArticleRequest;
import com.example.boot3jpa.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor // final 이 붙거나 @NotNull 이 붙은 필드로 생성자를 만들어준다.
@Service
public class BlogService {

    private final BlogRepository blogRepository;

    // 블로그 글 추가 메서드
    public Article save(AddArticleRequest request){
       Article article = request.toEntity();
       return blogRepository.save(article);
    }
}
