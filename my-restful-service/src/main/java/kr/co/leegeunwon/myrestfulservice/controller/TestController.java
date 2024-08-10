package kr.co.leegeunwon.myrestfulservice.controller;

import kr.co.leegeunwon.myrestfulservice.bean.Member;
import kr.co.leegeunwon.myrestfulservice.dao.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {
    @Autowired
    private ITestService testService;

    @GetMapping("/test")
    public List<Member> getAllMembers() {
        List<Member> members = testService.getAllMembers();
        return members;
    }
}
