package com.lrq.demo.service;

import com.github.pagehelper.Page;
import com.lrq.demo.model.User;

public interface UserService {
    User getUserByName(String name);
    void addUser(User user);
    Page<User> findByPage(String name,int pageNo, int pageSize);
}
