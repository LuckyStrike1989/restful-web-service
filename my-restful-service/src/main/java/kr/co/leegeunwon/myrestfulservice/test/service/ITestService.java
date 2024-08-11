package kr.co.leegeunwon.myrestfulservice.test.service;

import kr.co.leegeunwon.myrestfulservice.test.domain.Member;

import java.util.List;

public interface ITestService {
    public List<Member> getAllMembers();

    public void test();
}
