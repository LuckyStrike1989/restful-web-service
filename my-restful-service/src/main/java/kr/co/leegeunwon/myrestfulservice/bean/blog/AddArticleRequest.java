package kr.co.leegeunwon.myrestfulservice.bean.blog;

import kr.co.leegeunwon.myrestfulservice.domain.blog.Article;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddArticleRequest {

    /**
     * 제목
     */
    private String title;

    /**
     * 내용
     */
    private String content;

    /**
     * 생성자를 사용해 객체 생성
     * @return
     */
    public Article toEntity() {
        return Article.builder()
                .title(title)
                .content(content)
                .build();
    }
}
