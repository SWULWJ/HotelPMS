package com.hotelpms.controller;

import com.hotelpms.pojo.DispatchRecords;
import com.hotelpms.pojo.StaffInfo;
import com.hotelpms.service.Impl.DispatchRecordServiceImpl;
import com.hotelpms.service.Impl.StaffInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class DispatchRecordController {

    @Autowired
    private DispatchRecordServiceImpl dispatchRecordService;
    @Autowired
    private StaffInfoServiceImpl staffInfoService;

//    @RequestMapping(value = "/addDispatchRecord",method = RequestMethod.GET)
//    @ResponseBody
//    public String addDispatchRecord(
//            @RequestParam("id") int id,
//            @RequestParam("staff_id") int stuff_id,
//            @RequestParam("location") String location,
//            @RequestParam("start_time")Date start,
//            @RequestParam("end_time")Date end,
//            @RequestParam("type") String type,
//            @RequestParam("details") String details
//            ){
//        if(dispatchRecordService.addDispatchRecord(id,stuff_id,
//                location,start,end,type,details))
//            return "success";
//        return "failed";
//    }

    //增加一条派遣记录
    //输入: id,staffId,location,startTime,endTime,type,details
    //输出: success or failed
    @RequestMapping(value = "/addDispatchRecord",method = RequestMethod.GET)
    @ResponseBody
    public String addDispatchRecord(
            @RequestParam("id") String id,
            @RequestParam("staffId") String staff_id,
            @RequestParam("location") String location,
            @RequestParam("startTime")String start_time,
            @RequestParam("endTime")String end_time,
            @RequestParam("type") String type,
            @RequestParam("details") String details
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

        StaffInfo staffInfo = staffInfoService.queryStaffInfoById(Integer.parseInt(staff_id));

        if(dispatchRecordService.addDispatchRecord(Integer.parseInt(id),
                staffInfo, location,start,end,type,details))
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
//            @RequestParam("details") String details
//    ){
//        if(dispatchRecordService.updateDispatchRecord(id,stuff_id,
//                location,start,end,type,details))
//            return "success";
//        return "failed";
//    }


    //更新一条派遣记录
    //输入: id,staffId,location,startTime,endTime,type,details
    //输出: success or failed
    @RequestMapping(value = "/updateDispatchRecord",method = RequestMethod.GET)
    @ResponseBody
    public String updateDispatchRecord(
            @RequestParam("id") String id,
            @RequestParam("staffId") String staff_id,
            @RequestParam("location") String location,
            @RequestParam("startTime")String start_time,
            @RequestParam("endTime")String end_time,
            @RequestParam("type") String type,
            @RequestParam("details") String details
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
//            @RequestParam("id") int id
//    ){
//        if (dispatchRecordService.deleteDispatchRecordById(id))
//            return "success";
//        return "failed";
//    }


    //删除一条派遣记录
    //输入: id
    //输出: success or failed
    @RequestMapping(value = "/deleteDispatchRecordById",method = RequestMethod.GET)
    @ResponseBody
    public String deleteDispatchById(
            @RequestParam("id") String id
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


    //根据ID查询一条派遣记录
    //输入: id
    //输出: List<DispatchRecords>
    @RequestMapping(value = "/queryDispatchRecordById",method = RequestMethod.GET)
    @ResponseBody
    public List<DispatchRecords> queryDispatchRecordById(
            @RequestParam("id") String id
    ) {
        List<DispatchRecords> list = new ArrayList<>();
        list.add(dispatchRecordService.queryDispatchRecordById(Integer.parseInt(id)));
        return list;
    }

    //查询所有派遣记录
    //输入: 无
    //输出: List<DispatchRecords>
    @RequestMapping(value = "/queryAllDispatchRecord",method = RequestMethod.GET)
    @ResponseBody
    public List<DispatchRecords> queryAllDispatchRecord(){
        return dispatchRecordService.queryAllDispatchRecord();
    }

//    @RequestMapping(value = "/queryDispatchRecordByTime",method = RequestMethod.GET)
//    @ResponseBody
//    public List<DispatchRecords> queryDispatchRecordById(){
//        return dispatchRecordService.queryDispatchRecordByTime(start, end);
//    }


    //根据时间段查询派遣记录
    //输入: start_time,end_time
    //输出: List<DispatchRecords>
    @RequestMapping(value = "/queryDispatchRecordByTime",method = RequestMethod.GET)
    @ResponseBody
    public List<DispatchRecords> queryDispatchRecordById(
            @RequestParam("start_time") String start_time,
            @RequestParam("end_time") String end_time
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


    //根据 staffId 查询派遣记录
    //输入: staffId
    //输出: List<DispatchRecords>
    @RequestMapping(value = "/queryDispatchRecordByStaffId",method = RequestMethod.GET)
    @ResponseBody
    public List<DispatchRecords> queryDispatchRecordByStuffId(
            @RequestParam("staffId") String staff_id
    ){
        return dispatchRecordService.queryDispatchRecordByStaffId(Integer.parseInt(staff_id));
    }


    //根据 position 查询派遣记录
    //输入: position
    //输出: List<DispatchRecords>
    @RequestMapping(value = "/queryDispatchRecordByPosition",method = RequestMethod.GET)
    @ResponseBody
    public List<DispatchRecords> queryDispatchRecordByPosition(
            @RequestParam("position") String position
    ){
        return dispatchRecordService.queryDispatchRecordByPosition(position);
    }


    //根据 type 查询派遣记录
    //输入: type
    //输出: List<DispatchRecords>
    @RequestMapping(value = "/queryDispatchRecordByType",method = RequestMethod.GET)
    @ResponseBody
    public List<DispatchRecords> queryDispatchRecordByType(
            @RequestParam("type") String type
    ){
        return dispatchRecordService.queryDispatchRecordByType(type);
    }

    //根据 staffNumber 查询派遣记录
    //输入: staffNumber
    //输出: List<DispatchRecords>
    @RequestMapping(value = "/queryDispatchRecordByStaffNumber",method = RequestMethod.GET)
    @ResponseBody
    public List<DispatchRecords> queryDispatchRecordByStaffNumber(
            @RequestParam("staffNumber") String staffNumber
    ){
        return dispatchRecordService.queryDispatchRecordByStaffNumber(
                Integer.getInteger(staffNumber));
    }

}
