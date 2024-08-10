package kr.co.leegeunwon.myrestfulservice.dao;

import kr.co.leegeunwon.myrestfulservice.bean.Member;

import java.util.List;

public interface ITestService {
    public List<Member> getAllMembers();

    public void test();
}
