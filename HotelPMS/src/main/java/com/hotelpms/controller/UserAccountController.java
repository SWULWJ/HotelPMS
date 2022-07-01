package com.hotelpms.controller;

import com.hotelpms.pojo.UserAccount;
import com.hotelpms.service.UserAccountServiceImpl;
import com.hotelpms.service.UserService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

public class UserAccountController {

    private UserAccountServiceImpl userService;

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
     * 输出：String
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

    /*
     * @Author: 王海腾
     * @Date: 2022-6-30 19:30
     * 前端接口:delete_user
     * 前端参数：int id，
     * 输出：String
     * */

    @RequestMapping("/delete_user")
    public String DeleteUser(@RequestParam("id") int id,
                             Model model,
                             HttpSession httpSession){
        boolean result = userService.deleteUserById(id);
        if (result==true)
            return "Success";
        return "False";
    }

    /*
     * @Author: 王海腾
     * @Date: 2022-6-30 19:30
     * 前端接口:read_user_by_id
     * 前端参数：int id，
     * 输出：String
     * */

    @RequestMapping("/read_user_by_id")
    public String ReadUserById(@RequestParam("id") int id,
                             Model model,
                             HttpSession httpSession){
        UserAccount userAccount = userService.readUserById(id);
        if (userAccount!=null)
            return userAccount.toString();
        return "False";
    }

    /*
     * @Author: 王海腾
     * @Date: 2022-6-30 19:30
     * 前端接口:read_all_users
     * 前端参数：无
     * 输出：String
     * */

    @RequestMapping("/read_all_users")
    public String ReadAllUsers(){
        List<UserAccount> accounts = userService.readAllUser();
        return accounts.toString();
    }
}


