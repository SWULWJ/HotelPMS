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
            @RequestParam("auditing") boolean auditing,
            Model model,
            HttpSession httpSession
            ){
        if (billRecordService.addBillRecord(id,bill_num,staff_id,type,time,amount,details,auditing))
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
            @RequestParam("auditing") boolean auditing,
            Model model,
            HttpSession httpSession
    ){
        if (billRecordService.updateBillRecord(id,bill_num,staff_id,type,time,amount,details,auditing))
            return "Success";
        return "Failed";
    }


    @RequestMapping(value = "/deleteBillById",method = RequestMethod.GET)
    @ResponseBody
    public String deleteBillById(
            @RequestParam("id") int id,
            Model model,
            HttpSession httpSession
            ){
        if (billRecordService.deleteBillRecord(id))
            return "Success";
        return "Failed";
    }

    @RequestMapping(value = "/queryBillById",method = RequestMethod.GET)
    @ResponseBody
    public BillRecord queryBillById(
            @RequestParam("id") int id,
            Model model,
            HttpSession httpSession){
        return billRecordService.QueryRecordById(id);
    }

    @RequestMapping(value = "/queryAllBill",method = RequestMethod.GET)
    @ResponseBody
    public List<BillRecord> queryAllBill(
            Model model,
            HttpSession httpSession){
        return billRecordService.QueryAllRecord();
    }

    @RequestMapping(value = "/queryBillByTime",method = RequestMethod.GET)
    @ResponseBody
    public List<BillRecord> QueryBillByTime(
            @RequestParam("start") Date start_date,
            @RequestParam("end") Date end_date,
            Model model,
            HttpSession httpSession){
        return billRecordService.QueryRecordByTime(start_date,end_date);
    }

    @RequestMapping(value = "/queryBillByStaffId",method = RequestMethod.GET)
    @ResponseBody
    public List<BillRecord> queryBillByTime(
            @RequestParam("staff_id") int staff_id,
            Model model,
            HttpSession httpSession){
        return billRecordService.QueryRecordByStaffId(staff_id);
    }

    @RequestMapping(value = "/queryBillByStaffType",method = RequestMethod.GET)
    @ResponseBody
    public List<BillRecord> queryBillByTime(
            @RequestParam("type") String type,
            Model model,
            HttpSession httpSession){
        return billRecordService.QueryRecordByType(type);
    }

    @RequestMapping(value = "/queryBillByStaffAmount",method = RequestMethod.GET)
    @ResponseBody
    public List<BillRecord> queryBillByTime(
            @RequestParam("min") BigDecimal min,
            @RequestParam("max") BigDecimal max,
            Model model,
            HttpSession httpSession){
        return billRecordService.QueryRecordByAmount(min,max);
    }


}
