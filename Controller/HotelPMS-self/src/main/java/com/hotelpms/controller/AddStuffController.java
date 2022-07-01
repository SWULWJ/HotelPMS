package com.hotelpms.controller;


/*
* 根据员工的所有信息添加员工
*
* */

import com.hotelpms.service.AddStuffService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class AddStuffController {

    private AddStuffService addUserService;

    /*
    * @Author: 王海腾
    * @Date: 2022-6-30 16:30
     * 前端接口:add_stuff
     * 前端参数：int id，
     *         int staff_number，
     *         String name，
     *         String gender，
     *         int age，
     *         String position，
     *         String tel
    * */

    @RequestMapping("/add_stuff")
    public String AddStuff(
            @RequestParam("id") int id,
            @RequestParam("staff_number") int sn,
            @RequestParam("name") String name,
            @RequestParam("gender") String gender,
            @RequestParam("age") int age,
            @RequestParam("position") String pos,
            @RequestParam("tel") String tel,
            Model model,
            HttpSession httpSession) {
        boolean result = addUserService.addUser(id, sn, name, gender, age, pos, tel);
        if (result == true)
            return "Success";
        return "False";
    }
}
