package com.hotelpms.controller;

import com.hotelpms.service.StaffAccountService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

public class StuffAccountController {

    private StaffAccountService staffAccountService = new StaffAccountService();


    /*
     * @Author: 王海腾
     * @Date: 2022-6-30 16:30
     * 前端接口:update_stuff
     * 前端参数：int id，
     *         int staff_number，
     *         String name，
     *         String gender，
     *         int age，
     *         String position，
     *         String tel
     * */

    @RequestMapping("/update_stuff")
    public String UpdateStuff(
            @RequestParam("id") int id,
            @RequestParam("staff_number") int sn,
            @RequestParam("name") String name,
            @RequestParam("gender") String gender,
            @RequestParam("age") int age,
            @RequestParam("position") String pos,
            @RequestParam("tel") String tel,
            Model model,
            HttpSession httpSession) {
        boolean result = staffAccountService.updateUser(id, sn, name, gender, age, pos, tel);
        if (result == true)
            return "Success";
        return "False";
    }

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
        boolean result = staffAccountService.addUser(id, sn, name, gender, age, pos, tel);
        if (result == true)
            return "Success";
        return "False";
    }

}
