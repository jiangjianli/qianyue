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


    @Override
    public void saveUser(User user) {

        this.dao.save(user);
    }


    @Override
    public User getUserInfoByToken(String token) {


        User user = this.dao.findByToken(token);

        return user;
    }


    @Override
    public void deleteUserById(Integer id) {

        User user = this.dao.findById(id).get();
        if (user != null)
        {
            user.setDelFlag(1);
            this.dao.save(user);
        }else
        {
            throw new RuntimeException("已删除");
        }


    }
}
