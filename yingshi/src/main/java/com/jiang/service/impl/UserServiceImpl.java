package com.jiang.service.impl;

import com.jiang.dao.UserDao;
import com.jiang.pojo.User;
import com.jiang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserDao dao;


    @Override
    public User findUserByUserName(String userName) {

        User user = this.dao.findByUserName(userName);

        return user;
    }

    @Override
    public User findUserByUserNameAndPassword(String userName, String password) {

        User user = this.dao.findByUserNameAndPassword(userName,password);

        return user;

    }
}
