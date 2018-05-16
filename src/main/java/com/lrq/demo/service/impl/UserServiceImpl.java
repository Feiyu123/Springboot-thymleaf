package com.lrq.demo.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lrq.demo.dao.UserDao;
import com.lrq.demo.model.User;
import com.lrq.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl  implements UserService{
    @Autowired
    private UserDao userDao;

    @Override
    public User getUserByName(String name) {
        Map<String,Object> map = new HashMap<>();
        map.put("name",name);
        return userDao.getUserByName(map);
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public Page<User> findByPage(String name,int pageNo, int pageSize) {
        Map<String,Object> map = new HashMap<>();
        map.put("name",name);
        PageHelper.startPage(pageNo, pageSize);
        return userDao.findPageInfoByName(map);
    }
}
