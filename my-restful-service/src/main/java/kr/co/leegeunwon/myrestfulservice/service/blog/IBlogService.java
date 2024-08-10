package kr.co.leegeunwon.myrestfulservice.service.blog;

import kr.co.leegeunwon.myrestfulservice.bean.blog.AddArticleRequest;
import kr.co.leegeunwon.myrestfulservice.domain.blog.Article;

public interface IBlogService {
    public Article save(AddArticleRequest request);
}
