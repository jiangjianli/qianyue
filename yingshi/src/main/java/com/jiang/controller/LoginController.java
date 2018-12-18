package com.jiang.controller;

import com.jiang.pojo.User;
import com.jiang.service.UserService;
import com.jiang.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult login(@RequestParam("username") String username, @RequestParam("passwd") String password, HttpSession session)
    {
        System.out.println("login post " +username +password);

        User user = this.service.findUserByUserNameAndPassword(username,password);

//        JsonResult json = new JsonResult();
//
//        return json;

        if (user == null)
        {
            JsonResult json = JsonResult.error("用户名或密码错误");
            return json;
        }else
        {
            session.setAttribute("user",user.getId());
            return JsonResult.success("登录成功",user);
        }





    }




}
