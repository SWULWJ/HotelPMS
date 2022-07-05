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

    // 显示所有员工
    // 输入: 无
    // 输出: List<StaffInfo>
    @GetMapping(value = "/queryAllStaff")
    @ResponseBody
    public List<StaffInfo> queryAllStaff(){
        return staffInfoService.queryAllStaffInfo();
    }

//    //新增员工
//    @GetMapping(value = "/addStaff")
//    @ResponseBody
//    public String addStuff(
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

    //新增员工
    // 输入: id, staffNumber, name, gender, age, position, tel
    // 输出: success or failed
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
    // 输入: name
    // 输出: List<StaffInfo>
    @GetMapping(value = "queryStaffByName")
    @ResponseBody
    public List<StaffInfo> queryStaffInfoByName(
            @RequestParam("name") String name){
        return staffInfoService.queryStaffInfoByName(name);
    }

    //通过员工编号查找员工
    // 输入: stuffNumber
    // 输出: List<StaffInfo>
    @GetMapping(value = "queryStaffByStaffNumber")
    @ResponseBody
    public List<StaffInfo> queryStaffByStaffNumber(
            @RequestParam("stuffNumber") String stuffNumber
    ){
        ArrayList<StaffInfo> list = new ArrayList<>();
        list.add(staffInfoService.queryStaffInfoByStaffNumber(Integer.getInteger(stuffNumber)));
        return list;
    }




//    //更新员工信息
//    @GetMapping(value = "/updateStaff")
//    @ResponseBody
//    public String updateStuff(
//            @RequestParam("id") int id,
//            @RequestParam("staffNumber") int sn,
//            @RequestParam("name") String name,
//            @RequestParam("gender") String gender,
//            @RequestParam("age") int age,
//            @RequestParam("position") String pos,
//            @RequestParam("tel") String tel) {
//        if (staffInfoService.updateStaffInfo(id, sn, name, gender, age, pos, tel))
//            return "success";
//        return "failed";
//    }

    //更新员工信息
    // 输入: id, staffNumber, name, gender, age, position, tel
    // 输出: success or failed
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

//    //通过Id删除员工
//    @GetMapping(value = "/deleteStaff")
//    @ResponseBody
//    public String deleteStaff(
//            @RequestParam("id") int id){
//        if (staffInfoService.deleteStaffInfoById(id))
//            return "success";
//        return "failed";
//    }

    //通过Id删除员工
    // 输入: id
    // 输出: success or failed
    @GetMapping(value = "/deleteStaff")
    @ResponseBody
    public String deleteStaff(
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


}
