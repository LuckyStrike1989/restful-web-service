package kr.co.leegeunwon.myrestfulservice.blog.repository;

import kr.co.leegeunwon.myrestfulservice.blog.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article, Long> {
}
