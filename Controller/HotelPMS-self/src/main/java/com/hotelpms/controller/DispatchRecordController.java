package com.hotelpms.controller;

import com.hotelpms.pojo.DispatchRecords;
import com.hotelpms.pojo.HousingRecords;
import com.hotelpms.service.DispatchRecordServiceImpl;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

public class DispatchRecordController {

    private DispatchRecordServiceImpl dispatchRecordService;

    @RequestMapping(value = "/addDispatchRecord",method = RequestMethod.GET)
    @ResponseBody
    public JSONUtility addDispatchRecord(
            @RequestParam("id") int id,
            @RequestParam("staff_id") int stuff_id,
            @RequestParam("location") String location,
            @RequestParam("start_time")Date start,
            @RequestParam("end_time")Date end,
            @RequestParam("type") String type,
            @RequestParam("details") String details,
            Model model,
            HttpSession httpSession
            ){
        if(dispatchRecordService.addDispatchRecord(id,stuff_id,location,start,end,type,details))
            return new JSONUtility("Success","/");
        return new JSONUtility("Failed","/");
    }

    @RequestMapping(value = "/updateDispatchRecord",method = RequestMethod.GET)
    @ResponseBody
    public String updateDispatchRecord(
            @RequestParam("id") int id,
            @RequestParam("staff_id") int stuff_id,
            @RequestParam("location") String location,
            @RequestParam("start_time")Date start,
            @RequestParam("end_time")Date end,
            @RequestParam("type") String type,
            @RequestParam("details") String details,
            Model model,
            HttpSession httpSession
    ){
        if(dispatchRecordService.updateDispatchRecord(id,stuff_id,location,start,end,type,details))
            return "Success" ;
        return "Failed";
    }

    @RequestMapping(value = "/deleteDispatchRecordById",method = RequestMethod.GET)
    @ResponseBody
    public String deleteDispatchById(
            @RequestParam("id") int id,
            Model model,
            HttpSession httpSession
    ){
        if (dispatchRecordService.deleteDispatchRecordById(id))
            return "Success" ;
        return "Failed";
    }

    @RequestMapping(value = "/queryDispatchRecordById",method = RequestMethod.GET)
    @ResponseBody
    public DispatchRecords queryDispatchRecordById(
            @RequestParam("id") int id,
            Model model,
            HttpSession httpSession
    ) {
        return dispatchRecordService.queryDispatchRecordById(id);
    }

    @RequestMapping(value = "/queryAllDispatchRecord",method = RequestMethod.GET)
    @ResponseBody
    public List<DispatchRecords> queryDispatchRecordById(
            Model model,
            HttpSession httpSession
    ){
        return dispatchRecordService.queryAllDispatchRecord();
    }

    @RequestMapping(value = "/queryDispatchRecordByTime",method = RequestMethod.GET)
    @ResponseBody
    public List<DispatchRecords> queryDispatchRecordById(
            @RequestParam("start_time") Date start,
            @RequestParam("end_time") Date end,
            Model model,
            HttpSession httpSession
    ){
        return dispatchRecordService.queryDispatchRecordByTime(start,end);
    }

    @RequestMapping(value = "/queryDispatchRecordByStaffId",method = RequestMethod.GET)
    @ResponseBody
    public List<DispatchRecords> queryDispatchRecordByStuffId(
            @RequestParam("staff_id") int staff_id,
            Model model,
            HttpSession httpSession
    ){
        return dispatchRecordService.queryDispatchRecordByStaffId(staff_id);
    }

    @RequestMapping(value = "/queryDispatchRecordByPosition",method = RequestMethod.GET)
    @ResponseBody
    public List<DispatchRecords> queryDispatchRecordByStuffId(
            @RequestParam("position") String position,
            Model model,
            HttpSession httpSession
    ){
        return dispatchRecordService.queryDispatchRecordByPosition(position);
    }

    @RequestMapping(value = "/queryDispatchRecordByType",method = RequestMethod.GET)
    @ResponseBody
    public List<DispatchRecords> queryDispatchRecordByType(
            @RequestParam("type") String type,
            Model model,
            HttpSession httpSession
    ){
        return dispatchRecordService.queryDispatchRecordByType(type);
    }
}
