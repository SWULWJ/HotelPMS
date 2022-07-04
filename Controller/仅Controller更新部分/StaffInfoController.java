package com.hotelpms.controller;

import com.hotelpms.pojo.StaffInfo;
import com.hotelpms.service.Impl.StaffInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public class StaffInfoController {

    @Autowired
    private StaffInfoServiceImpl staffInfoService;

//    @RequestMapping(value = "/UpdateStaff",method = RequestMethod.GET)
//    @ResponseBody
//    public String UpdateStuff(
//            @RequestParam("id") int id,
//            @RequestParam("staffNumber") int sn,
//            @RequestParam("name") String name,
//            @RequestParam("gender") String gender,
//            @RequestParam("age") int age,
//            @RequestParam("position") String pos,
//            @RequestParam("tel") String tel) {
//        if (staffInfoService.updateStaffInfo(id, sn, name, gender, age, pos, tel))
//            return "success";
//        return "False";
//    }

    @RequestMapping(value = "/updateStaff",method = RequestMethod.GET)
    @ResponseBody
    public String UpdateStuff(
            @RequestParam("id") String id,
            @RequestParam("staffNumber") String sn,
            @RequestParam("name") String name,
            @RequestParam("gender") String gender,
            @RequestParam("age") String age,
            @RequestParam("position") String pos,
            @RequestParam("tel") String tel) {
        if (staffInfoService.updateStaffInfo(Integer.parseInt(id), Integer.parseInt(sn),
                name, gender, Integer.parseInt(age), pos, tel))
            return "success";
        return "failed";
    }

//    @RequestMapping(value = "/AddStaff",method = RequestMethod.GET)
//    @ResponseBody
//    public String AddStuff(
//            @RequestParam("id") int id,
//            @RequestParam("staffNumber") int sn,
//            @RequestParam("name") String name,
//            @RequestParam("gender") String gender,
//            @RequestParam("age") int age,
//            @RequestParam("position") String pos,
//            @RequestParam("tel") String tel) {
//        if (staffInfoService.addStaff(id, sn, name, gender, age, pos, tel))
//            return "success";
//        return "failed";
//    }

    @RequestMapping(value = "/addStaff",method = RequestMethod.GET)
    @ResponseBody
    public String AddStuff(
            @RequestParam("id") String id,
            @RequestParam("staffNumber") String sn,
            @RequestParam("name") String name,
            @RequestParam("gender") String gender,
            @RequestParam("age") String age,
            @RequestParam("position") String pos,
            @RequestParam("tel") String tel) {
        if (staffInfoService.addStaff(Integer.parseInt(id), Integer.parseInt(sn),
                name, gender, Integer.parseInt(age), pos, tel))
            return "success";
        return "failed";
    }

//    @RequestMapping(value = "/DeleteStaff",method = RequestMethod.GET)
//    @ResponseBody
//    public String DeleteStaff(
//            @RequestParam("id") int id){
//        if (staffInfoService.deleteStaffInfoById(id))
//            return "success";
//        return "False";
//    }

    @RequestMapping(value = "/deleteStaff",method = RequestMethod.GET)
    @ResponseBody
    public String DeleteStaff(
            @RequestParam("id") String id){
        if (staffInfoService.deleteStaffInfoById(Integer.parseInt(id)))
            return "success";
        return "failed";
    }

//    @RequestMapping(value = "/QueryStuffById",method = RequestMethod.GET)
//    @ResponseBody
//    public StaffInfo QueryStuffById(
//            @RequestParam("id") int id){
//        return staffInfoService.queryStaffInfoById(id);
//    }

    @RequestMapping(value = "/queryStuffById",method = RequestMethod.GET)
    @ResponseBody
    public StaffInfo QueryStuffById(
            @RequestParam("id") String id){
        return staffInfoService.queryStaffInfoById(Integer.parseInt(id));
    }

    @RequestMapping(value = "queryStuffByName",method = RequestMethod.GET)
    @ResponseBody
    public List<StaffInfo> QueryStuffByName(
            @RequestParam("/name") String name){
        return staffInfoService.queryStaffInfoByName(name);
    }

    @RequestMapping(value = "/queryAllStaff",method = RequestMethod.GET)
    @ResponseBody
    public List<StaffInfo> QueryAllStaff(){
        return staffInfoService.queryAllStaffInfo();
    }
}
