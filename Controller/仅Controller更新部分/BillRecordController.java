package com.hotelpms.controller;

import com.hotelpms.pojo.BillRecord;
import com.hotelpms.service.Impl.BillRecordServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class BillRecordController {

    @Autowired
    private BillRecordServiceImpl billRecordService;

    @RequestMapping(value = "/addBillRecord",method = RequestMethod.GET)
    @ResponseBody
    public String addBillRecord(
            @RequestParam("id") int id,
            @RequestParam("bill_number") int bill_num,
            @RequestParam("staff_id") int staff_id,
            @RequestParam("type") String type,
            @RequestParam("time")Date time,
            @RequestParam("amount") BigDecimal amount,
            @RequestParam("details") String details,
            @RequestParam("auditing") boolean auditing
            ){
        if (billRecordService.addBillRecord(id,bill_num,
                staff_id,type,time,amount,details,auditing))
            return "Success";
        return "Failed";
    }

    @RequestMapping(value = "/updateBillRecord",method = RequestMethod.GET)
    @ResponseBody
    public String updateBillRecord(
            @RequestParam("id") int id,
            @RequestParam("bill_number") int bill_num,
            @RequestParam("staff_id") int staff_id,
            @RequestParam("type") String type,
            @RequestParam("time")Date time,
            @RequestParam("amount") BigDecimal amount,
            @RequestParam("details") String details,
            @RequestParam("auditing") boolean auditing
    ){
        if (billRecordService.updateBillRecord(id,bill_num,staff_id,
                type,time,amount,details,auditing))
            return "Success";
        return "Failed";
    }


    @RequestMapping(value = "/deleteBillById",method = RequestMethod.GET)
    @ResponseBody
    public String deleteBillById(
            @RequestParam("id") int id
            ){
        if (billRecordService.deleteBillRecord(id))
            return "Success";
        return "Failed";
    }

    @RequestMapping(value = "/queryBillById",method = RequestMethod.GET)
    @ResponseBody
    public BillRecord queryBillById(
            @RequestParam("id") int id){
        return billRecordService.QueryRecordById(id);
    }

    @RequestMapping(value = "/queryAllBill",method = RequestMethod.GET)
    @ResponseBody
    public List<BillRecord> queryAllBill(){
        return billRecordService.QueryAllRecord();
    }

    @RequestMapping(value = "/queryBillByTime",method = RequestMethod.GET)
    @ResponseBody
    public List<BillRecord> QueryBillByTime(
            @RequestParam("start") Date start_date,
            @RequestParam("end") Date end_date){
        return billRecordService.QueryRecordByTime(start_date,end_date);
    }

    @RequestMapping(value = "/queryBillByStaffId",method = RequestMethod.GET)
    @ResponseBody
    public List<BillRecord> queryBillByTime(
            @RequestParam("staff_id") int staff_id){
        return billRecordService.QueryRecordByStaffId(staff_id);
    }

    @RequestMapping(value = "/queryBillByStaffType",method = RequestMethod.GET)
    @ResponseBody
    public List<BillRecord> queryBillByTime(
            @RequestParam("type") String type){
        return billRecordService.QueryRecordByType(type);
    }

    @RequestMapping(value = "/queryBillByStaffAmount",method = RequestMethod.GET)
    @ResponseBody
    public List<BillRecord> queryBillByTime(
            @RequestParam("min") BigDecimal min,
            @RequestParam("max") BigDecimal max){
        return billRecordService.QueryRecordByAmount(min,max);
    }
}
