package com.hotelpms.controller;

import com.hotelpms.pojo.BillRecord;
import com.hotelpms.service.BillRecordService;
import com.hotelpms.service.BillRecordServiceImpl;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class BillRecordController {

    private BillRecordServiceImpl billRecordService = new BillRecordServiceImpl();




    @RequestMapping(value = "/add_bill_record",method = RequestMethod.GET)
    @ResponseBody
    public String AddBillRecord(
            @RequestParam("id") int id,
            @RequestParam("bill_number") int bill_num,
            @RequestParam("staff_id") int staff_id,
            @RequestParam("type") String type,
            @RequestParam("time")Date time,
            @RequestParam("amount") BigDecimal amount,
            @RequestParam("details") String details,
            @RequestParam("auditing") boolean auditing,
            Model model,
            HttpSession httpSession
            ){
        if (billRecordService.addBillRecord(id,bill_num,staff_id,type,time,amount,details,auditing))
            return "Success";
        return "Failed";
    }

    @RequestMapping(value = "/update_bill_record",method = RequestMethod.GET)
    @ResponseBody
    public String UpdateBillRecord(
            @RequestParam("id") int id,
            @RequestParam("bill_number") int bill_num,
            @RequestParam("staff_id") int staff_id,
            @RequestParam("type") String type,
            @RequestParam("time")Date time,
            @RequestParam("amount") BigDecimal amount,
            @RequestParam("details") String details,
            @RequestParam("auditing") boolean auditing,
            Model model,
            HttpSession httpSession
    ){
        if (billRecordService.updateBillRecord(id,bill_num,staff_id,type,time,amount,details,auditing))
            return "Success";
        return "Failed";
    }


    @RequestMapping(value = "/delete_bill_by_id",method = RequestMethod.GET)
    @ResponseBody
    public String DeleteBillById(
            @RequestParam("id") int id,
            Model model,
            HttpSession httpSession
            ){
        if (billRecordService.deleteBillRecord(id))
            return "Success";
        return "Failed";
    }

    @RequestMapping(value = "query_bill_by_id",method = RequestMethod.GET)
    @ResponseBody
    public BillRecord QueryBillById(
            @RequestParam("id") int id,
            Model model,
            HttpSession httpSession){
        return billRecordService.QueryRecordById(id);
    }

    @RequestMapping(value = "query_all_bill",method = RequestMethod.GET)
    @ResponseBody
    public List<BillRecord> QueryAllBill(
            Model model,
            HttpSession httpSession){
        return billRecordService.QueryAllRecord();
    }

    @RequestMapping(value = "query_bill_by_time",method = RequestMethod.GET)
    @ResponseBody
    public List<BillRecord> QueryBillByTime(
            @RequestParam("start") Date start_date,
            @RequestParam("end") Date end_date,
            Model model,
            HttpSession httpSession){
        return billRecordService.QueryRecordByTime(start_date,end_date);
    }

    @RequestMapping(value = "query_bill_by_staff_id",method = RequestMethod.GET)
    @ResponseBody
    public List<BillRecord> QueryBillByTime(
            @RequestParam("staff_id") int staff_id,
            Model model,
            HttpSession httpSession){
        return billRecordService.QueryRecordByStaffId(staff_id);
    }

    @RequestMapping(value = "query_bill_by_staff_type",method = RequestMethod.GET)
    @ResponseBody
    public List<BillRecord> QueryBillByTime(
            @RequestParam("type") String type,
            Model model,
            HttpSession httpSession){
        return billRecordService.QueryRecordByType(type);
    }

    @RequestMapping(value = "query_bill_by_staff_amount",method = RequestMethod.GET)
    @ResponseBody
    public List<BillRecord> QueryBillByTime(
            @RequestParam("min") BigDecimal min,
            @RequestParam("max") BigDecimal max,
            Model model,
            HttpSession httpSession){
        return billRecordService.QueryRecordByAmount(min,max);
    }


}
