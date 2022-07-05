package com.hotelpms.controller;

import com.hotelpms.pojo.StaffInfo;
import com.hotelpms.service.Impl.StaffInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StaffInfoController {

    @Autowired
    private StaffInfoServiceImpl staffInfoService;

    //显示所有员工
    @GetMapping(value = "/queryAllStaff")
    @ResponseBody
    public
    List<StaffInfo> QueryAllStaff() {
        List<StaffInfo> list = staffInfoService.queryAllStaffInfo();
        list.forEach(System.out::println);
        return staffInfoService.queryAllStaffInfo();
    }

    //新增员工
    @GetMapping(value = "/addStaff")
    @ResponseBody
    public String addStuff(
            @RequestParam("id") String id,
            @RequestParam("staffNumber") String sn,
            @RequestParam("name") String name,
            @RequestParam("gender") String gender,
            @RequestParam("age") String age,
            @RequestParam("position") String pos,
            @RequestParam("tel") String tel) {
        if (staffInfoService.addStaff(Integer.parseInt(id),
                Integer.parseInt(sn), name, gender,
                Integer.parseInt(age), pos, tel))
            return "success";
        return "failed";
    }

    //通过名字查找员工
    @GetMapping(value = "/queryStaffByName")
    @ResponseBody
    public List<StaffInfo> QueryStuffByName(
            @RequestParam("/name") String name){
        return staffInfoService.queryStaffInfoByName(name);
    }

    //通过员工编号查找员工
    @GetMapping(value = "/queryStaffByStaffNumber")
    @ResponseBody
    public List<StaffInfo> queryStaffByStaffNumber(
            @RequestParam("staffNumber") String staffNumber
    ){
        List<StaffInfo> list = new ArrayList<>();
        list.add(staffInfoService.queryStaffInfoByStaffNumber(Integer.parseInt(staffNumber)));
        return list;
    }

    //更新员工信息
    @GetMapping(value = "/updateStaff")
    @ResponseBody
    public String updateStuff(
            @RequestParam("id") String id,
            @RequestParam("staffNumber") String sn,
            @RequestParam("name") String name,
            @RequestParam("gender") String gender,
            @RequestParam("age") String age,
            @RequestParam("position") String pos,
            @RequestParam("tel") String tel) {
        if (staffInfoService.updateStaffInfo(Integer.parseInt(id),
                Integer.parseInt(sn), name, gender,
                Integer.parseInt(age), pos, tel))
            return "success";
        return "failed";
    }

    //通过Id删除员工
    @GetMapping(value = "/deleteStaff")
    @ResponseBody
    public String deleteStaff(
            @RequestParam("id") String id) {
        if (staffInfoService.deleteStaffInfoById(Integer.parseInt(id)))
            return "success";
        return "failed";
    }
}