package kr.co.leegeunwon.myrestfulservice.dao;

import kr.co.leegeunwon.myrestfulservice.bean.User;

import java.util.List;

public interface IUserDaoService {
    public List<User> findAll();

    public User save(User user);

    public User findOne(int id);

    public User deleteById(int id);
}
