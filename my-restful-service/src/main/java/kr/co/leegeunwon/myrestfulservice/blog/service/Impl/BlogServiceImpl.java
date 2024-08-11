package kr.co.leegeunwon.myrestfulservice.blog.service.Impl;

import kr.co.leegeunwon.myrestfulservice.blog.bean.AddArticleRequest;
import kr.co.leegeunwon.myrestfulservice.blog.service.IBlogService;
import kr.co.leegeunwon.myrestfulservice.blog.domain.Article;
import kr.co.leegeunwon.myrestfulservice.blog.repository.BlogRepository;
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
