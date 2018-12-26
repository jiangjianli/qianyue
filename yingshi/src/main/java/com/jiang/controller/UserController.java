package com.jiang.controller;

import com.jiang.pojo.User;
import com.jiang.service.UserService;
import com.jiang.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
public class UserController {


    @Autowired
    private UserService service;

    @RequestMapping(value = "/getuserinfo",method = RequestMethod.GET)
    @ResponseBody
    public JsonResult getUserInfoByToken(String token)
    {

        if (StringUtils.isEmpty(token))
        {
            JsonResult json = JsonResult.error("tokken 为空");
            return json;
        }

        User user = this.service.getUserInfoByToken(token);

        if (user == null)
        {
            return JsonResult.error("未查询到用户信息");
        }else
        {
            return JsonResult.success("查找成功",user);
        }


    }



    @RequestMapping(value = "/addorupdateuser",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult addorupdateuser(User user)
    {


            if (StringUtils.isEmpty(user.getPassword()) || StringUtils.isEmpty(user.getUserName()))
            {
                return JsonResult.error("参数错误");
            }
            //添加用户
            this.service.saveUser(user);
            JsonResult json = JsonResult.success("操作成功");
            return json;


    }


    @RequestMapping(value = "/deleteUser",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult addorupdateuser(Integer id)
    {


        if (id != null) {
            //添加用户
            this.service.deleteUserById(id);
            JsonResult json = JsonResult.success("操作成功");
            return json;
        }


        return JsonResult.error("参数错误");



    }



}
