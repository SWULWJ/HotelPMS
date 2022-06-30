package com.hotelpms.controller;

import com.hotelpms.service.UserService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

public class UserController {

    private UserService userService;

    /*
     * @Author: 王海腾
     * @Date: 2022-6-30 17:30
     * 前端接口:update_user
     * 前端参数：int id，
     *         int staff_id，
     *         String username，
     *         String password，
     * */

    @RequestMapping("/update_user")
    public String UpdateUser(
            @RequestParam("id") int id,
            @RequestParam("stuff_id") int si,
            @RequestParam("account") String account,
            @RequestParam("password") String password,
            Model model,
            HttpSession httpSession) {
        boolean result = userService.updateUser(id,si,account,password);
        if (result == true)
            return "Success";
        return "False";
    }

    /*
     * @Author: 王海腾
     * @Date: 2022-6-30 17:30
     * 前端接口:add_user
     * 前端参数：int id，
     *         int staff_id，
     *         String username，
     *         String password，
     * */

    @RequestMapping("/add_user")
    public String AddUser(
            @RequestParam("id") int id,
            @RequestParam("stuff_id") int si,
            @RequestParam("account") String account,
            @RequestParam("password") String password,
            Model model,
            HttpSession httpSession) {
        boolean result = userService.addUser(id,si,account,password);
        if (result == true)
            return "Success";
        return "False";
    }
}


