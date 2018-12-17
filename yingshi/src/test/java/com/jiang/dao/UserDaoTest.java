package com.jiang.dao;

import com.jiang.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest


public class UserDaoTest {

    @Autowired
    private  UserDao dao;

    @Test
    public void testsave()
    {
        User user = new User();
        user.setUserName("jiang1");
        user.setPassword("123456");
        user.setNickname("c测试");
        user.setPhone("15528088884");

        dao.save(user);
    }


    
}