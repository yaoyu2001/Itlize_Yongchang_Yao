
package com.example.demo.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RequestMapping("shop")
@RestController
public class DemoController {

    @Resource
    private UserService userServiceImpl;

    @RequestMapping("")
    public String demo(){
        return "Welcome to Shopping System";
    }

    @RequestMapping("findById")
    public String findById(Long id){
        return userServiceImpl.findById(id).toString();
    }

    @RequestMapping("findByName")
    public User findByName(String name){
        return userServiceImpl.findNameHql(name);
    }

    @RequestMapping("DeleteById")
    public String deleteById(Long id){
        String name = userServiceImpl.findById(id).getUserName();
        userServiceImpl.deleteById(id);

        return "User " + name + " Deleted !";
    }

    @RequestMapping("saveUser")
    public User saveUser(String name, String password, Long id){
        User user = new User();
        user.setUserName(name);
        user.setPassword(password);
        user.setId(id);
        //Set date
        Date date=new Date();
        String strDateFormat = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
        user.setCreateDate(sdf.format(date));
        return userServiceImpl.save(user);
    }

}