package kr.co.leegeunwon.myrestfulservice.service.blog.Impl;

import kr.co.leegeunwon.myrestfulservice.bean.blog.AddArticleRequest;
import kr.co.leegeunwon.myrestfulservice.domain.blog.Article;
import kr.co.leegeunwon.myrestfulservice.repository.blog.BlogRepository;
import kr.co.leegeunwon.myrestfulservice.service.blog.IBlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor    // final이 붙거나 @NotNull이 붙은 필드의 생성자 추가
@Service
public class BlogServiceImpl implements IBlogService {
    private BlogRepository blogRepository;

    @Override
    public Article save(AddArticleRequest request) {
        return blogRepository.save(request.toEntity());
    }
}
