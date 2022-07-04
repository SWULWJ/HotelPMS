package com.hotelpms.controller;

import com.hotelpms.pojo.StaffInfo;
import com.hotelpms.service.Impl.StaffInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class StaffInfoController {

    @Autowired
    private StaffInfoServiceImpl staffInfoService;

    //显示所有员工
    @GetMapping(value = "/queryAllStaff")
    @ResponseBody
    public
    List<StaffInfo> QueryAllStaff(){
        return staffInfoService.queryAllStaffInfo();
    }

    //新增员工
    @GetMapping(value = "/addStaff")
    @ResponseBody
    public String AddStuff(
            @RequestParam("id") int id,
            @RequestParam("staff_number") int sn,
            @RequestParam("name") String name,
            @RequestParam("gender") String gender,
            @RequestParam("age") int age,
            @RequestParam("position") String pos,
            @RequestParam("tel") String tel) {
        if (staffInfoService.addStaff(id, sn, name, gender, age, pos, tel))
            return "success";
        return "failed";
    }

    //通过名字查找员工
    @GetMapping(value = "queryStuffByName")
    @ResponseBody
    public List<StaffInfo> QueryStuffByName(
            @RequestParam("/name") String name){
        return staffInfoService.queryStaffInfoByName(name);
    }

    //通过员工编号查找员工（传入string：stuffNumber返回员工对象）url：/queryStaffByStaffNumber




    //更新员工信息
    @GetMapping(value = "/updateStaff")
    @ResponseBody
    public String UpdateStuff(
            @RequestParam("id") int id,
            @RequestParam("staff_number") int sn,
            @RequestParam("name") String name,
            @RequestParam("gender") String gender,
            @RequestParam("age") int age,
            @RequestParam("position") String pos,
            @RequestParam("tel") String tel) {
        if (staffInfoService.updateStaffInfo(id, sn, name, gender, age, pos, tel))
            return "success";
        return "failed";
    }

    //通过Id删除员工
    @GetMapping(value = "/deleteStaff")
    @ResponseBody
    public String DeleteStaff(
            @RequestParam("id") int id){
        if (staffInfoService.deleteStaffInfoById(id))
            return "success";
        return "failed";
    }

//    @RequestMapping(value = "/QueryStuffById",method = RequestMethod.GET)
//    @ResponseBody
//    public StaffInfo QueryStuffById(
//            @RequestParam("id") int id){
//        return staffInfoService.queryStaffInfoById(id);
//    }




}
