package com.jiang.pojo;


import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@DynamicUpdate
@DynamicInsert
@ToString
@Table(name = "user")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String userName;

    private String token;

    private String password;

    private String nickname;

    private String phone;

    private Date createTime;

    private Date updateTime;


    private Integer status;

    private Integer delFlag;



}
