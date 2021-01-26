package com.test.springboot.controller;

import com.test.springboot.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.concurrent.BlockingDeque;

/**
 * @author清梦
 * @site www.xiaomage.com
 * @company xxx公司
 * @create 2020-10-24 15:05
 */
@Controller
public class LoginController {
    @Autowired
    private UserService userService;
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/dashboard")
    public String index(){
        return "dashboard";
    }
    @PostMapping("checkLogin")
    public String checkLogin(String username, String password, ModelMap map){
       boolean re= userService.checkLogin(username,password);
       if (re){
           return "redirect:/dashboard";
       }
       map.put("error","用户名或密码错误");
        return "login";

    }
}
