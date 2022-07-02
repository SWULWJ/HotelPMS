package com.hotelpms.controller;

import com.hotelpms.pojo.UserAccount;
import com.hotelpms.service.UserAccountService;
import com.hotelpms.service.UserAccountServiceImpl;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

public class UserController {

    private UserAccountServiceImpl userService = new UserAccountServiceImpl();

    /*
     * @Author: 王海腾
     * @Date: 2022-6-30 17:30
     * 前端接口:update_user
     * 前端参数：int id，
     *         int staff_id，
     *         String username，
     *         String password，
     * 输出：String
     * */

    @RequestMapping(value = "/update_user",method = RequestMethod.GET)
    @ResponseBody
    public JSONUtility UpdateUser(
            @RequestParam("id") int id,
            @RequestParam("stuff_id") int si,
            @RequestParam("account") String account,
            @RequestParam("password") String password,
            Model model,
            HttpSession httpSession) {
        if (userService.updateUser(id,si,account,password))
            return new JSONUtility("Success","/");
        return new JSONUtility("Failed","/");
    }

    /*
     * @Author: 王海腾
     * @Date: 2022-6-30 17:30
     * 前端接口:add_user
     * 前端参数：int id，
     *         int staff_id，
     *         String username，
     *         String password，
     * 输出：String
     * */

    @RequestMapping(value = "/add_user",method = RequestMethod.GET)
    @ResponseBody
    public JSONUtility AddUser(
            @RequestParam("id") int id,
            @RequestParam("stuff_id") int si,
            @RequestParam("account") String account,
            @RequestParam("password") String password,
            Model model,
            HttpSession httpSession) {
        if (userService.addUser(id,si,account,password))
            return new JSONUtility("Success","/");
        return new JSONUtility("Failed","/");
    }

    /*
     * @Author: 王海腾
     * @Date: 2022-6-30 19:30
     * 前端接口:delete_user
     * 前端参数：int id，
     * 输出：String
     * */

    @RequestMapping(value = "/delete_user",method = RequestMethod.GET)
    @ResponseBody
    public JSONUtility DeleteUser(@RequestParam("id") int id,
                             Model model,
                             HttpSession httpSession){
        if (userService.deleteUserById(id))
            return new JSONUtility("Success","/");
        return new JSONUtility("Failed","/");
    }

    /*
     * @Author: 王海腾
     * @Date: 2022-6-30 19:30
     * 前端接口:read_user_by_id
     * 前端参数：int id，
     * 输出：String
     * */

    @RequestMapping(value = "/read_user_by_id",method = RequestMethod.GET)
    @ResponseBody
    public JSONUtility ReadUserById(@RequestParam("id") int id,
                             Model model,
                             HttpSession httpSession){
        UserAccount userAccount = userService.readUserById(id);
        if (userAccount!=null)
            return new JSONUtility(userAccount.toString(),"/");
        return new JSONUtility("Failed","/");
    }


    /*
     * @Author: 王海腾
     * @Date: 2022-6-30 19:30
     * 前端接口:read_all_users
     * 前端参数：无
     * 输出：String
     * */

    @RequestMapping(value = "/read_all_users",method = RequestMethod.GET)
    @ResponseBody
    public JSONUtility ReadAllUsers() {
        List<UserAccount> accounts = userService.readAllUser();
        return new JSONUtility(accounts.toString(), "/");
    }
}


