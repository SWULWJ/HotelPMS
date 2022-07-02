package com.hotelpms.controller;

import com.hotelpms.pojo.StaffInfo;
import com.hotelpms.service.StaffInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public class StaffInfoController {

    @Autowired
    private StaffInfoServiceImpl staffInfoService;

    @RequestMapping(value = "/UpdateStaff",method = RequestMethod.GET)
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
            return "Success";
        return "False";
    }

    @RequestMapping(value = "/AddStaff",method = RequestMethod.GET)
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
            return "Success";
        return "False";
    }

    @RequestMapping(value = "/DeleteStaff",method = RequestMethod.GET)
    @ResponseBody
    public String DeleteStaff(
            @RequestParam("id") int id){
        if (staffInfoService.deleteStaffInfoById(id))
            return "Success";
        return "False";
    }

    @RequestMapping(value = "/QueryStuffById",method = RequestMethod.GET)
    @ResponseBody
    public StaffInfo QueryStuffById(
            @RequestParam("id") int id){
        return staffInfoService.queryStaffInfoById(id);
    }

    @RequestMapping(value = "QueryStuffByName",method = RequestMethod.GET)
    @ResponseBody
    public List<StaffInfo> QueryStuffByName(
            @RequestParam("/name") String name){
        return staffInfoService.queryStaffInfoByName(name);
    }

    @RequestMapping(value = "/QueryAllStaff",method = RequestMethod.GET)
    @ResponseBody
    public List<StaffInfo> QueryAllStaff(){
        return staffInfoService.queryAllStaffInfo();
    }
}
