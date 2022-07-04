package com.hotelpms.controller;

import com.hotelpms.service.UserLoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class UserLoginController {

    private UserLoginService userLoginService = new UserLoginService();

    @RequestMapping(value = "/userLogin",method = RequestMethod.GET)
    @ResponseBody
    public String userLogin(
            @RequestParam("username")String username,
            @RequestParam("password")String password,
            Model model,
            HttpSession session) {

        boolean result = userLoginService.login_judge(username,password);

        if(result == true){
            session.setAttribute("loginUser", username);
            return "/system.html";
        }else {
            model.addAttribute("msg", "用户名或密码错误");
            return "login";
        }
    }
}
