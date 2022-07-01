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

    @RequestMapping(value = "add_dispatch_record",method = RequestMethod.GET)
    @ResponseBody
    public JSONUtility AddDispatchRecord(
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

    @RequestMapping(value = "update_dispatch_record",method = RequestMethod.GET)
    @ResponseBody
    public String UpdateDispatchRecord(
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

    @RequestMapping(value = "delete_dispatch_record_by_id",method = RequestMethod.GET)
    @ResponseBody
    public String DeleteDispatchById(
            @RequestParam("id") int id,
            Model model,
            HttpSession httpSession
    ){
        if (dispatchRecordService.deleteDispatchRecordById(id))
            return "Success" ;
        return "Failed";
    }

    @RequestMapping(value = "query_dispatch_record_by_id",method = RequestMethod.GET)
    @ResponseBody
    public DispatchRecords QueryDispatchRecordById(
            @RequestParam("id") int id,
            Model model,
            HttpSession httpSession
    ) {
        return dispatchRecordService.queryDispatchRecordById(id);
    }

    @RequestMapping(value = "query_all_dispatch_record",method = RequestMethod.GET)
    @ResponseBody
    public List<DispatchRecords> QueryDispatchRecordById(
            Model model,
            HttpSession httpSession
    ){
        return dispatchRecordService.queryAllDispatchRecord();
    }

    @RequestMapping(value = "query_dispatch_record_by_time",method = RequestMethod.GET)
    @ResponseBody
    public List<DispatchRecords> QueryDispatchRecordById(
            @RequestParam("start_time") Date start,
            @RequestParam("end_time") Date end,
            Model model,
            HttpSession httpSession
    ){
        return dispatchRecordService.queryDispatchRecordByTime(start,end);
    }

    @RequestMapping(value = "query_dispatch_record_by_staff_id",method = RequestMethod.GET)
    @ResponseBody
    public List<DispatchRecords> QueryDispatchRecordByStuffId(
            @RequestParam("staff_id") int staff_id,
            Model model,
            HttpSession httpSession
    ){
        return dispatchRecordService.queryDispatchRecordByStaffId(staff_id);
    }

    @RequestMapping(value = "query_dispatch_record_by_position",method = RequestMethod.GET)
    @ResponseBody
    public List<DispatchRecords> QueryDispatchRecordByStuffId(
            @RequestParam("position") String position,
            Model model,
            HttpSession httpSession
    ){
        return dispatchRecordService.queryDispatchRecordByPosition(position);
    }

    @RequestMapping(value = "query_dispatch_record_by_type",method = RequestMethod.GET)
    @ResponseBody
    public List<DispatchRecords> QueryDispatchRecordByType(
            @RequestParam("type") String type,
            Model model,
            HttpSession httpSession
    ){
        return dispatchRecordService.queryDispatchRecordByType(type);
    }
}
