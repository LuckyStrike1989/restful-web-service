package kr.co.leegeunwon.myrestfulservice.User.service;

import kr.co.leegeunwon.myrestfulservice.User.bean.User;

import java.util.List;

public interface IUserDaoService {
    public List<User> findAll();

    public User save(User user);

    public User findOne(int id);

    public User deleteById(int id);
}
