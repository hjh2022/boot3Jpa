package com.example.boot3jpa.dto;

import com.example.boot3jpa.dao.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddArticleRequest {
    private String title;
    private String content;

    public Article toEntity(){ // 빌더 패턴을 사용해 DTO 를 엔티티로 만들어준다.
        return Article.builder()
                .title(title)
                .content(content)
                .build();
    }
}
