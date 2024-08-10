package kr.co.leegeunwon.myrestfulservice.dao.impl;

import kr.co.leegeunwon.myrestfulservice.bean.Member;
import kr.co.leegeunwon.myrestfulservice.dao.ITestService;
import kr.co.leegeunwon.myrestfulservice.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TestService implements ITestService {
    @Autowired
    private MemberRepository memberRepository;

    @Override
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    @Override
    public void test() {
        memberRepository.save(new Member(3L, "A"));

        Optional<Member> member = memberRepository.findById(3L);    // 단건 조회
        List<Member> allMembers = memberRepository.findAll();       // 전체 조회

        memberRepository.deleteById(3L);
    }
}
