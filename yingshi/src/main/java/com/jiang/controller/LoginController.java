package com.jiang.controller;

import com.jiang.pojo.LoginParamVo;
import com.jiang.pojo.User;
import com.jiang.service.UserService;
import com.jiang.util.JsonResult;
import com.jiang.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {


    @Autowired
    private UserService service;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String index()
    {
        System.out.print("login");
        return "login/login";

    }






    @RequestMapping(value = "/api/login",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult login(@RequestBody LoginParamVo model)
    {
        System.out.println("login post " +model.getUsername() +model.getPassword());

        if (StringUtils.isEmpty(model.getUsername()) || StringUtils.isEmpty(model.getPassword()))
        {

            return JsonResult.error("请输入用户名或者密码");
        }




        User user = this.service.findUserByUserNameAndPassword(model.getUsername(),model.getPassword());


        if (user == null)
        {
            JsonResult json = JsonResult.error("用户名或密码错误");

            return json;
        }else
        {
           // session.setAttribute("user",user.getId());
            String token = TokenUtil.getToken();
            user.setToken(token);

            this.service.saveUser(user);

            return JsonResult.success("登录成功",user.getToken());
        }


    }







}
