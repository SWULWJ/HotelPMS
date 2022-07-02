package com.hotelpms.controller;

import com.hotelpms.pojo.StaffInfo;
import com.hotelpms.pojo.UserAccount;
import com.hotelpms.service.StaffInfoServiceImpl;
import com.hotelpms.service.UserAccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public class UserController {

    @Autowired
    private UserAccountServiceImpl userService;

    @Autowired
    private StaffInfoServiceImpl staffInfoService;

    @RequestMapping(value = "/UpdateUser",method = RequestMethod.GET)
    @ResponseBody
    public String UpdateUser(
            @RequestParam("id") int id,
            @RequestParam("account") String account,
            @RequestParam("password") String password,
            @RequestParam("staff_info_id") int staffInfoId) {
        StaffInfo staffInfo = staffInfoService.queryStaffInfoById(staffInfoId);
        if (userService.updateUser(id,account, password,staffInfo))
            return "Success";
        return "Failed";
    }

    @RequestMapping(value = "/AddUser",method = RequestMethod.GET)
    @ResponseBody
    public String AddUser(
            @RequestParam("id") int id,
            @RequestParam("account") String account,
            @RequestParam("password") String password,
            @RequestParam("staff_info_id") int staffInfoId) {
        StaffInfo staffInfo = staffInfoService.queryStaffInfoById(staffInfoId);
        if (userService.addUser(id,account, password,staffInfo))
            return "Success";
        return "Failed";
    }

    @RequestMapping(value = "/DeleteUser",method = RequestMethod.GET)
    public String DeleteUser(@RequestParam("id") int id){
        if (userService.deleteUserById(id))
            return "Success";
        return "Failed";
    }

    @RequestMapping(value = "/ReadUserById",method = RequestMethod.GET)
    public UserAccount ReadUserById(@RequestParam("id") int id){
        return userService.readUserById(id);
    }


    @RequestMapping(value = "/ReadAllUsers",method = RequestMethod.GET)
    public List<UserAccount> ReadAllUsers(Model model) {
        return userService.readAllUser();
    }
}


