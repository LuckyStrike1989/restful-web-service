package kr.co.leegeunwon.myrestfulservice.domain.blog;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    // 빌더 패턴으로 객체 생성
    @Builder
    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
