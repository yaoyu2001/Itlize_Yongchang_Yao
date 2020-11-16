package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserRepository;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @类名称 UserServiceImpl.java
 * @类描述 <pre>业务层具体实现</pre>
 * @作者  xingsfdz xingsfdz@163.com
 * @创建时间 2019年12月19日 下午6:26:07
 * @版本 1.00
 *
 * @修改记录
 * <pre>
 *     版本                       修改人 		修改日期 		 修改内容描述
 *     ----------------------------------------------
 *     1.00 	xingsfdz 	2019年12月19日
 *     ----------------------------------------------
 * </pre>
 */
@Service
@Transactional
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