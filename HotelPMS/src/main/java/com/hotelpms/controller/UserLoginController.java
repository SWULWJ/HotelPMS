package com.hotelpms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserLoginController {
    @RequestMapping("/userLogin")
    public String userLogin(
            @RequestParam("username")String username,
            @RequestParam("password")String password,
            Model model) {

        //放入service
        if(username.equals("admin") && password.equals("admin"))
            return "redirect:/system.html";
        else {
            model.addAttribute("msg", "用户名或密码错误");
            return "login";
        }
    }
}
