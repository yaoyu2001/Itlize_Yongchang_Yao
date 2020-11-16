package com.example.demo.service;
import com.example.demo.entity.User;

public interface UserService {

    public User findById(Long id);//查询用户通过id

    public User save(User user);//保存用户

    public User findNameHql(String name);

    public void deleteById(Long id);

}