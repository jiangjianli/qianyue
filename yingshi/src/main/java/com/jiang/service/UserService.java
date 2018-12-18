package com.jiang.service;

import com.jiang.pojo.User;
import org.springframework.stereotype.Service;


public interface UserService {


    User findUserByUserName(String userName);

    User findUserByUserNameAndPassword(String userName,String password);



}
