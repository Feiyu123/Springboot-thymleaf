package com.lrq.demo.dao;

import com.github.pagehelper.Page;
import com.lrq.demo.model.User;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface UserDao {
    User getUserByName(Map<String,Object> map);
    void addUser(User user);
    Page<User> findPageInfoByName(Map<String,Object> map);

}
