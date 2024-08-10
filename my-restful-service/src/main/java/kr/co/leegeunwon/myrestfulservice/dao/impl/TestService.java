package kr.co.leegeunwon.myrestfulservice.dao.impl;

import kr.co.leegeunwon.myrestfulservice.bean.Member;
import kr.co.leegeunwon.myrestfulservice.dao.ITestService;
import kr.co.leegeunwon.myrestfulservice.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService implements ITestService {
    @Autowired
    private MemberRepository memberRepository;

    @Override
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }
}
