package kr.co.leegeunwon.myrestfulservice.blog.service;

import kr.co.leegeunwon.myrestfulservice.blog.bean.AddArticleRequest;
import kr.co.leegeunwon.myrestfulservice.blog.domain.Article;

public interface IBlogService {
    public Article save(AddArticleRequest request);
}
