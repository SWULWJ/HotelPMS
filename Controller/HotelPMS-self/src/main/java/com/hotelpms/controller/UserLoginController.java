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

    /*@Author: 王海腾
     *@Date: 2022-6-30-14:45
     *@Test: 单元测试已完成
     * */
    @RequestMapping(value = "/userLogin",method = RequestMethod.GET)
    @ResponseBody
    public JSONUtility userLogin(
            @RequestParam("username")String username,
            @RequestParam("password")String password,
            Model model,
            HttpSession session) {

        boolean result = true;//userLoginService.login_judge(username,password);

        if(result == true){
            session.setAttribute("loginUser", username);
            JSONUtility jsonUtility = new JSONUtility("success","/system.html");
            return jsonUtility;
        }else {
            model.addAttribute("msg", "用户名或密码错误");
            JSONUtility jsonUtility = new JSONUtility("faild","/");
            return jsonUtility;
        }
    }
}
