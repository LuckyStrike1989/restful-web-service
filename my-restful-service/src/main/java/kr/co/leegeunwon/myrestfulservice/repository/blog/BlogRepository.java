package kr.co.leegeunwon.myrestfulservice.repository.blog;

import kr.co.leegeunwon.myrestfulservice.domain.blog.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article, Long> {
}
