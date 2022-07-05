package com.hotelpms.controller;

import com.hotelpms.pojo.DispatchRecords;
import com.hotelpms.service.Impl.DispatchRecordServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DispatchRecordController {

    @Autowired
    private DispatchRecordServiceImpl dispatchRecordService;

//    @RequestMapping(value = "/addDispatchRecord",method = RequestMethod.GET)
//    @ResponseBody
//    public String addDispatchRecord(
//            @RequestParam("id") int id,
//            @RequestParam("staff_id") int stuff_id,
//            @RequestParam("location") String location,
//            @RequestParam("start_time")Date start,
//            @RequestParam("end_time")Date end,
//            @RequestParam("type") String type,
//            @RequestParam("details") String details,
//            Model model,
//            HttpSession httpSession
//            ){
//        if(dispatchRecordService.addDispatchRecord(id,stuff_id,
//                location,start,end,type,details))
//            return "success";
//        return "failed";
//    }

    @RequestMapping(value = "/addDispatchRecord",method = RequestMethod.GET)
    @ResponseBody
    public String addDispatchRecord(
            @RequestParam("id") String id,
            @RequestParam("staffId") String staff_id,
            @RequestParam("location") String location,
            @RequestParam("startTime")String start_time,
            @RequestParam("endTime")String end_time,
            @RequestParam("type") String type,
            @RequestParam("details") String details,
            Model model,
            HttpSession httpSession
    ){

        Date start = new Date();
        try {
            start = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(start_time);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Date end = new Date();
        try {
            end = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(end_time);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if(dispatchRecordService.addDispatchRecord(Integer.parseInt(id),
                Integer.parseInt(staff_id), location,start,end,type,details))
            return "success";
        return "failed";
    }

//    @RequestMapping(value = "/updateDispatchRecord",method = RequestMethod.GET)
//    @ResponseBody
//    public String updateDispatchRecord(
//            @RequestParam("id") int id,
//            @RequestParam("staff_id") int stuff_id,
//            @RequestParam("location") String location,
//            @RequestParam("start_time")Date start,
//            @RequestParam("end_time")Date end,
//            @RequestParam("type") String type,
//            @RequestParam("details") String details,
//            Model model,
//            HttpSession httpSession
//    ){
//        if(dispatchRecordService.updateDispatchRecord(id,stuff_id,
//                location,start,end,type,details))
//            return "success";
//        return "failed";
//    }

    @RequestMapping(value = "/updateDispatchRecord",method = RequestMethod.GET)
    @ResponseBody
    public String updateDispatchRecord(
            @RequestParam("id") String id,
            @RequestParam("staffId") String staff_id,
            @RequestParam("location") String location,
            @RequestParam("startTime")String start_time,
            @RequestParam("endTime")String end_time,
            @RequestParam("type") String type,
            @RequestParam("details") String details,
            Model model,
            HttpSession httpSession
    ){

        Date start = new Date();
        try {
            start = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(start_time);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Date end = new Date();
        try {
            end = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(end_time);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if(dispatchRecordService.updateDispatchRecord(Integer.parseInt(id),
                Integer.parseInt(staff_id), location,start,end,type,details))
            return "success";
        return "failed";
    }

//    @RequestMapping(value = "/deleteDispatchRecordById",method = RequestMethod.GET)
//    @ResponseBody
//    public String deleteDispatchById(
//            @RequestParam("id") int id,
//            Model model,
//            HttpSession httpSession
//    ){
//        if (dispatchRecordService.deleteDispatchRecordById(id))
//            return "success";
//        return "failed";
//    }

    @RequestMapping(value = "/deleteDispatchRecordById",method = RequestMethod.GET)
    @ResponseBody
    public String deleteDispatchById(
            @RequestParam("id") String id,
            Model model,
            HttpSession httpSession
    ){
        if (dispatchRecordService.deleteDispatchRecordById(Integer.parseInt(id)))
            return "success";
        return "failed";
    }

//    @RequestMapping(value = "/queryDispatchRecordById",method = RequestMethod.GET)
//    @ResponseBody
//    public DispatchRecords queryDispatchRecordById(
//            @RequestParam("id") int id
//    ) {
//        return dispatchRecordService.queryDispatchRecordById(id);
//    }

    @RequestMapping(value = "/queryDispatchRecordById",method = RequestMethod.GET)
    @ResponseBody
    public List<DispatchRecords> queryDispatchRecordById(
            @RequestParam("id") String id
    ) {
        List<DispatchRecords> list = new ArrayList<>();
        list.add(dispatchRecordService.queryDispatchRecordById(Integer.parseInt(id)));
        return list;
    }

    @RequestMapping(value = "/queryAllDispatchRecord",method = RequestMethod.GET)
    @ResponseBody
    public List<DispatchRecords> queryAllDispatchRecord(){
        return dispatchRecordService.queryAllDispatchRecord();
    }

//    @RequestMapping(value = "/queryDispatchRecordByTime",method = RequestMethod.GET)
//    @ResponseBody
//    public List<DispatchRecords> queryDispatchRecordById(
//            @RequestParam("start_time") Date start,
//            @RequestParam("end_time") Date end,
//            Model model,
//            HttpSession httpSession
//    ){
//        return dispatchRecordService.queryDispatchRecordByTime(start, end);
//    }

    @RequestMapping(value = "/queryDispatchRecordByTime",method = RequestMethod.GET)
    @ResponseBody
    public List<DispatchRecords> queryDispatchRecordById(
            @RequestParam("start_time") String start_time,
            @RequestParam("end_time") String end_time,
            Model model,
            HttpSession httpSession
    ){

        Date start = new Date();
        try {
            start = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(start_time);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Date end = new Date();
        try {
            end = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(end_time);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return dispatchRecordService.queryDispatchRecordByTime(start, end);
    }

//    @RequestMapping(value = "/queryDispatchRecordByStaffId",method = RequestMethod.GET)
//    @ResponseBody
//    public List<DispatchRecords> queryDispatchRecordByStuffId(
//            @RequestParam("staff_id") int staff_id
//    ){
//       return dispatchRecordService.queryDispatchRecordByStaffId(staff_id);
//    }


    @RequestMapping(value = "/queryDispatchRecordByStaffId",method = RequestMethod.GET)
    @ResponseBody
    public List<DispatchRecords> queryDispatchRecordByStuffId(
            @RequestParam("staffId") String staff_id
    ){
        return dispatchRecordService.queryDispatchRecordByStaffId(Integer.parseInt(staff_id));
    }

    @RequestMapping(value = "/queryDispatchRecordByPosition",method = RequestMethod.GET)
    @ResponseBody
    public List<DispatchRecords> queryDispatchRecordByPosition(
            @RequestParam("position") String position
    ){
        return dispatchRecordService.queryDispatchRecordByPosition(position);
    }

    @RequestMapping(value = "/queryDispatchRecordByType",method = RequestMethod.GET)
    @ResponseBody
    public List<DispatchRecords> queryDispatchRecordByType(
            @RequestParam("type") String type
    ){
        return dispatchRecordService.queryDispatchRecordByType(type);
    }

    @RequestMapping(value = "/queryDispatchRecordByStaffNumber",method = RequestMethod.GET)
    @ResponseBody
    public List<DispatchRecords> queryDispatchRecordByStaffNumber(
            @RequestParam("staffNumber") String staffNumber
    ){
        return dispatchRecordService.queryDispatchRecordByStaffNumber(
                Integer.getInteger(staffNumber));
    }

}
