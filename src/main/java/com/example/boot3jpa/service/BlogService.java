package com.example.boot3jpa.service;

import com.example.boot3jpa.dao.Article;
import com.example.boot3jpa.dto.AddArticleRequest;
import com.example.boot3jpa.dto.UpdateArticleRequest;
import com.example.boot3jpa.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor // final 이 붙거나 @NotNull 이 붙은 필드로 생성자를 만들어준다.
@Service
public class BlogService {

    private final BlogRepository blogRepository;

    // 블로그 글 추가 메서드
    public Article save(AddArticleRequest request){
       Article article = request.toEntity();
       return blogRepository.save(article);
    }

    public List<Article> getList(){
        return blogRepository.findAll();
    }

    public Article getOne(Long id){
       Article article = blogRepository.findById(id)
               .orElseThrow(() -> new IllegalArgumentException("not found:"+ id));
       return article;
    }

    public void delete(Long id){
        blogRepository.deleteById(id);
    }

    @Transactional
    public Article update(Long id, UpdateArticleRequest request){
       Article article = blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found:"+ id));

       article.update(request.getTitle(), request.getContent());
       return article;
    }
}
