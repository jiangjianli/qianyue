package com.jiang.dao;

import com.jiang.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Integer> {



    User findByUserName(String userName);


    User findByUserNameAndPassword(String userName,String passwprd);


}
