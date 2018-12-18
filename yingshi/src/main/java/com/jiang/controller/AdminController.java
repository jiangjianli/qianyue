package com.jiang.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {



    @RequestMapping("/index")
    public String Index()
    {
        System.out.println("layout");
        return "ui-navbars";
    }


}
