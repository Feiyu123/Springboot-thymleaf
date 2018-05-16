package com.lrq.demo.controller;

import com.lrq.demo.model.User;
import com.lrq.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;


    @GetMapping("/toUserPage")
    public String toUserPage(Model model){
        LOGGER.info("跳转到用户页面");
        model.addAttribute("name","Henry");
        return "userPage";
    }


    @PostMapping("/getUser")
    @ResponseBody
    public User getUser(String name){
        LOGGER.info("获取用户信息.name={}",name);
        User user =  userService.getUserByName(name);
        LOGGER.info("获取用户信息.user={}",user.toString());
        return  user;
    }
}
