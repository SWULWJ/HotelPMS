package com.hotelpms.controller;

import com.hotelpms.pojo.StaffInfo;
import com.hotelpms.service.StaffInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class StaffInfoController {

    private StaffInfoService staffInfoService;


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

    @RequestMapping(value = "/updateStaff",
            method = RequestMethod.GET)
    @ResponseBody
    public String updateStuff(
            @RequestParam("id") int id,
            @RequestParam("staff_number") int sn,
            @RequestParam("name") String name,
            @RequestParam("gender") String gender,
            @RequestParam("age") int age,
            @RequestParam("position") String pos,
            @RequestParam("tel") String tel,
            Model model,
            HttpSession httpSession) {
        if (staffInfoService.updateStaffInfo(id, sn, name, gender,
                age, pos, tel))
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

    @RequestMapping(value = "/addStaff",
            method = RequestMethod.GET)
    @ResponseBody
    public String addStuff(
            @RequestParam("id") int id,
            @RequestParam("staff_number") int sn,
            @RequestParam("name") String name,
            @RequestParam("gender") String gender,
            @RequestParam("age") int age,
            @RequestParam("position") String pos,
            @RequestParam("tel") String tel,
            Model model,
            HttpSession httpSession) {
        if (staffInfoService.addStaff(id, sn, name, gender,
                age, pos, tel))
            return "Success";
        return "False";
    }

    /*
     * @Author: 王海腾
     * @Date: 2022-7-1 9:40
     * 前端接口:delete_staff
     * 前端参数：int id
     * 输出：String
     * */

    @RequestMapping(value = "/deleteStaff",
            method = RequestMethod.GET)
    @ResponseBody
    public String DeleteStaff(
            @RequestParam("id") int id,
            Model model,
            HttpSession httpSession) {
        if (staffInfoService.deleteStaffInfoById(id))
            return "Success";
        return "False";
    }

    /*
     * @Author: 王海腾
     * @Date: 2022-7-1 9:40
     * 前端接口:query_stuff_by_id
     * 前端参数：int id
     * 输出：String
     * */

    @RequestMapping(value = "/queryStuffById",
            method = RequestMethod.GET)
    @ResponseBody
    public StaffInfo queryStuffById(
            @RequestParam("id") int id,
            Model model,
            HttpSession httpSession) {
        return staffInfoService.queryStaffInfoById(id);
    }

    /*
     * @Author: 王海腾
     * @Date: 2022-7-1 9:47
     * 前端接口:query_stuff_by_name
     * 前端参数：String name
     * 输出：String
     * */

    @RequestMapping(value = "/queryStuffByName",
            method = RequestMethod.GET)
    @ResponseBody
    public List<StaffInfo> queryStuffByName(
            @RequestParam("/name") String name,
            Model model,
            HttpSession httpSession) {
        return staffInfoService.queryStaffInfoByName(name);
    }

    /*
     * @Author: 王海腾
     * @Date: 2022-7-1 9:47
     * 前端接口:query_all_staff
     * 前端参数：int id
     * 输出：String
     * */

    @RequestMapping("/queryAllStaff")
    public String queryAllStaff(Model model) {
        List<StaffInfo> list = staffInfoService.queryAllStaffInfo();
        model.addAttribute("staffInfoList", list);
        return "concierge";
    }
}
