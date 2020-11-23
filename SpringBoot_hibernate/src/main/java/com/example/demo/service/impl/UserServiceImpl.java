package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserRepository;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional // Guarantee all manipulates all completed
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userDao;

    public User findById(Long id) {
        return userDao.findById(id);
    }

    public User save(User user) {
        return userDao.save(user);
    }

    public User findNameHql(String name) {
        return userDao.findNameHql(name);
    }

    public void deleteById(Long id){
        userDao.deleteById(id);
    }


}