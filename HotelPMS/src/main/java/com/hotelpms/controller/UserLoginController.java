//package com.hotelpms.controller;
//
//import com.hotelpms.service.UserLoginService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import javax.servlet.http.HttpSession;
//
//@Controller
//public class UserLoginController {
//
//    private UserLoginService userLoginService = new UserLoginService();
//
//
//    /*@Author: 王海腾
//     *@Date: 2022-6-30-14:45
//     *@Test: 单元测试已完成
//     * */
//
//    @RequestMapping("/userLogin")
//    public String userLogin(
//            @RequestParam("username")String username,
//            @RequestParam("password")String password,
//            Model model,
//            HttpSession session) {
//
//        //放入service
//        if(username.equals("admin") && password.equals("admin")) {
//            session.setAttribute("loginUser", username);
//            return "redirect:/system.html";
//        } else {
//            model.addAttribute("msg", "用户名或密码错误");
//            return "login";
//        }
//
//    }
//}
