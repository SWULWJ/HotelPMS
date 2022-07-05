package com.hotelpms.controller;

import com.hotelpms.pojo.StaffInfo;
import com.hotelpms.pojo.UserAccount;
import com.hotelpms.service.Impl.StaffInfoServiceImpl;
import com.hotelpms.service.Impl.UserAccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserAccountController {

    @Autowired
    private UserAccountServiceImpl userService;
    @Autowired
    private StaffInfoServiceImpl staffInfoService;

    //账号登陆
    @PostMapping(value = "/userLogin")
    public String userLogin(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            Model model,
            HttpSession session
    ) {
        if(userService.loginJudge(username,password)) {
            session.setAttribute("loginUser", username);
            return "redirect:/system.html";
        }

        String msg = "用户名或密码错误";
        model.addAttribute("msg", msg);
        return "login";
    }









    @RequestMapping(value = "/updateUser",method = RequestMethod.GET)
    @ResponseBody
    public String UpdateUser(
            @RequestParam("id") String id,
            @RequestParam("account") String account,
            @RequestParam("password") String password,
            @RequestParam("staffInfo") String staffInfoId) {
        StaffInfo staffInfo = staffInfoService.queryStaffInfoById(Integer.parseInt(staffInfoId));
        if (userService.updateUser(Integer.parseInt(id),account, password,staffInfo))
            return "success";
        return "failed";
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
//            return "success";
//        return "failed";
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
            return "success";
        return "failed";
    }

//    @RequestMapping(value = "/DeleteUser",method = RequestMethod.GET)
//    public String DeleteUser(@RequestParam("id") int id){
//        if (userService.deleteUserById(id))
//            return "success";
//        return "failed";
//    }

    @RequestMapping(value = "/deleteUser",method = RequestMethod.GET)
    public String DeleteUser(@RequestParam("id") String id){
        if (userService.deleteUserById(Integer.parseInt(id)))
            return "success";
        return "failed";
    }

//    @RequestMapping(value = "/ReadUserById",method = RequestMethod.GET)
//    public UserAccount ReadUserById(@RequestParam("id") int id){
//        return userService.readUserById(id);
//    }

    @RequestMapping(value = "/readUserById",method = RequestMethod.GET)
    public UserAccount ReadUserById(@RequestParam("id") String id){
        return userService.readUserById(Integer.parseInt(id));
    }

    @RequestMapping(value = "/readAllUsers",method = RequestMethod.GET)
    public List<UserAccount> ReadAllUsers() {
        return userService.readAllUser();
    }





}


