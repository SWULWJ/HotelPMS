package com.hotelpms.controller;

import com.hotelpms.pojo.StaffInfo;
import com.hotelpms.pojo.UserAccount;
import com.hotelpms.service.Impl.StaffInfoServiceImpl;
import com.hotelpms.service.Impl.UserAccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public class UserAccountController {

    @Autowired
    private UserAccountServiceImpl userService;

    @Autowired
    private StaffInfoServiceImpl staffInfoService;

//    @RequestMapping(value = "/UpdateUser",method = RequestMethod.GET)
//    @ResponseBody
//    public String UpdateUser(
//            @RequestParam("id") int id,
//            @RequestParam("account") String account,
//            @RequestParam("password") String password,
//            @RequestParam("staffInfo") int staffInfoId) {
//        StaffInfo staffInfo = staffInfoService.queryStaffInfoById(staffInfoId);
//        if (userService.updateUser(id,account, password,staffInfo))
//            return "Success";
//        return "Failed";
//    }

    @RequestMapping(value = "/updateUser",method = RequestMethod.GET)
    @ResponseBody
    public String UpdateUser(
            @RequestParam("id") String id,
            @RequestParam("account") String account,
            @RequestParam("password") String password,
            @RequestParam("staffInfo") String staffInfoId) {
        StaffInfo staffInfo = staffInfoService.queryStaffInfoById(Integer.parseInt(staffInfoId));
        if (userService.updateUser(Integer.parseInt(id),account, password,staffInfo))
            return "Success";
        return "Failed";
    }

//    @RequestMapping(value = "/AddUser",method = RequestMethod.GET)
//    @ResponseBody
//    public String AddUser(
//            @RequestParam("id") int id,
//            @RequestParam("account") String account,
//            @RequestParam("password") String password,
//            @RequestParam("staffInfo") int staffInfoId) {
//        StaffInfo staffInfo = staffInfoService.queryStaffInfoById(staffInfoId);
//        if (userService.addUser(id,account, password,staffInfo))
//            return "Success";
//        return "Failed";
//    }

    @RequestMapping(value = "/addUser",method = RequestMethod.GET)
    @ResponseBody
    public String AddUser(
            @RequestParam("id") String id,
            @RequestParam("account") String account,
            @RequestParam("password") String password,
            @RequestParam("staffInfo") String staffInfoId) {
        StaffInfo staffInfo = staffInfoService.queryStaffInfoById(Integer.parseInt(staffInfoId));
        if (userService.addUser(Integer.parseInt(id),account, password,staffInfo))
            return "Success";
        return "Failed";
    }

//    @RequestMapping(value = "/DeleteUser",method = RequestMethod.GET)
//    public String DeleteUser(@RequestParam("id") int id){
//        if (userService.deleteUserById(id))
//            return "Success";
//        return "Failed";
//    }

    @RequestMapping(value = "/deleteUser",method = RequestMethod.GET)
    public String DeleteUser(@RequestParam("id") String id){
        if (userService.deleteUserById(Integer.parseInt(id)))
            return "Success";
        return "Failed";
    }

//    @RequestMapping(value = "/ReadUserById",method = RequestMethod.GET)
//    public UserAccount ReadUserById(@RequestParam("id") int id){
//        return userService.readUserById(id);
//    }

    @RequestMapping(value = "/readUserById",method = RequestMethod.GET)
    public UserAccount ReadUserById(@RequestParam("id") String id){
        return userService.readUserById(Integer.parseInt(id));
    }

    @RequestMapping(value = "/ReadAllUsers",method = RequestMethod.GET)
    public List<UserAccount> ReadAllUsers() {
        return userService.readAllUser();
    }
}


