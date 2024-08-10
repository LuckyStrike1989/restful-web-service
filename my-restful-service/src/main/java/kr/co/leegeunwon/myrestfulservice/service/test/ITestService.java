package kr.co.leegeunwon.myrestfulservice.service.test;

import kr.co.leegeunwon.myrestfulservice.domain.member.Member;

import java.util.List;

public interface ITestService {
    public List<Member> getAllMembers();

    public void test();
}
