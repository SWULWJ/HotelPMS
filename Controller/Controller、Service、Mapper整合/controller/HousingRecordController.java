package com.hotelpms.controller;

import com.hotelpms.pojo.HousingRecords;
import com.hotelpms.service.Impl.HousingRecordsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HousingRecordController {

    @Autowired
    private HousingRecordsServiceImpl hosingRecordsService;

//    @RequestMapping(value = "/addHousingRecord",method = RequestMethod.GET)
//    @ResponseBody
//    public String addHousingRecord(
//            @RequestParam("id") int id,
//            @RequestParam("roomId") int room_id,
//            @RequestParam("tenantId") int tenant_id,
//            @RequestParam("checkInTime") Date check_in_time,
//            @RequestParam("checkOutTime") Date check_out_time,
//            @RequestParam("price")BigDecimal price
//    ){
//        if(hosingRecordsService.addHosingRecord(id,room_id,tenant_id,check_in_time,check_out_time,price))
//            return "success";
//        return "failed";
//    }

    @RequestMapping(value = "/addHousingRecord",method = RequestMethod.GET)
    @ResponseBody
    public String addHousingRecord(
            @RequestParam("id") String id,
            @RequestParam("roomId") String room_id,
            @RequestParam("tenantId") String tenant_id,
            @RequestParam("checkInTime") String check_in_time,
            @RequestParam("checkOutTime") String check_out_time,
            @RequestParam("price")String price
    ){

        Date start = new Date();
        try {
            start = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(check_in_time);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Date end = new Date();
        try {
            end = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(check_in_time);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if(hosingRecordsService.addHosingRecord(Integer.parseInt(id),
                Integer.parseInt(room_id),Integer.parseInt(tenant_id),start,end,
                new BigDecimal(price)))
            return "success";
        return "failed";
    }

//    @RequestMapping(value = "/updateHousingRecord",method = RequestMethod.GET)
//    @ResponseBody
//    public String updateHousingRecord(
//            @RequestParam("id") int id,
//            @RequestParam("roomId") int room_id,
//            @RequestParam("tenantId") int tenant_id,
//            @RequestParam("checkInTime") Date check_in_time,
//            @RequestParam("checkOutTime") Date check_out_time,
//            @RequestParam("price")BigDecimal price
//    ){
//        if(hosingRecordsService.updateHousingRecord(id,room_id,tenant_id,check_in_time,check_out_time,price))
//            return "success";
//        return "failed";
//    }

    @RequestMapping(value = "/updateHousingRecord",method = RequestMethod.GET)
    @ResponseBody
    public String updateHousingRecord(
            @RequestParam("id") String id,
            @RequestParam("roomId") String room_id,
            @RequestParam("tenantId") String tenant_id,
            @RequestParam("checkInTime") String check_in_time,
            @RequestParam("checkOutTime") String check_out_time,
            @RequestParam("price")String price
    ){

        Date start = new Date();
        try {
            start = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(check_in_time);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Date end = new Date();
        try {
            end = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(check_in_time);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if(hosingRecordsService.updateHousingRecord(Integer.parseInt(id),
                Integer.parseInt(room_id),Integer.parseInt(tenant_id),start,end,
                new BigDecimal(price)))
            return "success";
        return "failed";
    }

//    @RequestMapping(value = "/deleteHousingRecord",method = RequestMethod.GET)
//    @ResponseBody
//    public String deleteHousingRecord(
//            @RequestParam("id") int id
//    ){
//        if (hosingRecordsService.deleteHousingRecordById(id))
//            return "success";
//        return "failed";
//    }

    @RequestMapping(value = "/deleteHousingRecord",method = RequestMethod.GET)
    @ResponseBody
    public String deleteHousingRecord(
            @RequestParam("id") String id
    ){
        if (hosingRecordsService.deleteHousingRecordById(Integer.parseInt(id)))
            return "success";
        return "failed";
    }

//    @RequestMapping(value = "/QueryHousingRecordById",method = RequestMethod.GET)
//    @ResponseBody
//    public HousingRecords queryHousingRecordById(
//            @RequestParam("id") int id
//    ){
//        return hosingRecordsService.queryHousingRecordById(id);
//    }

    @RequestMapping(value = "/queryHousingRecordById",method = RequestMethod.GET)
    @ResponseBody
    public List<HousingRecords> queryHousingRecordById(
            @RequestParam("id") String id
    ){
        List<HousingRecords> list = new ArrayList<>();
        list.add(hosingRecordsService.queryHousingRecordById(Integer.parseInt(id)));
        return list;
    }

//    @RequestMapping(value = "/QueryHousingRecordByTime",method = RequestMethod.GET)
//    @ResponseBody
//    public List<HousingRecords> queryHousingRecordByTime(
//            @RequestParam("check_in_time") Date check_in_time,
//            @RequestParam("check_out_time") Date check_out_time
//    ){
//        return hosingRecordsService.queryHousingRecordByTime(check_in_time,check_out_time);
//    }

    @RequestMapping(value = "/QueryHousingRecordByTime",method = RequestMethod.GET)
    @ResponseBody
    public List<HousingRecords> queryHousingRecordByTime(
            @RequestParam("check_in_time") String check_in_time,
            @RequestParam("check_out_time") String check_out_time
    ){

        Date start = new Date();
        try {
            start = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(check_in_time);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Date end = new Date();
        try {
            end = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(check_in_time);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return hosingRecordsService.queryHousingRecordByTime(start,end);
    }

//    @RequestMapping(value = "/QueryHousingRecordByTime",method = RequestMethod.GET)
//    @ResponseBody
//    public List<HousingRecords> queryHousingRecordByRoom(
//            @RequestParam("room_id") int room_id
//    ){
//        return hosingRecordsService.queryHousingRecordByRoom(room_id);
//    }

    @RequestMapping(value = "/QueryHousingRecordByTime",method = RequestMethod.GET)
    @ResponseBody
    public List<HousingRecords> queryHousingRecordByRoom(
            @RequestParam("room_id") String room_id
    ){
        return hosingRecordsService.queryHousingRecordByRoom(Integer.parseInt(room_id));
    }

//    @RequestMapping(value = "/QueryHousingRecordByTenant",method = RequestMethod.GET)
//    @ResponseBody
//    public List<HousingRecords> queryHousingRecordByTenant(
//            @RequestParam("tenant_id") int tenant_id
//    ){
//        return hosingRecordsService.queryHousingRecordByTenant(tenant_id);
//    }

    @RequestMapping(value = "/QueryHousingRecordByTenant",method = RequestMethod.GET)
    @ResponseBody
    public List<HousingRecords> queryHousingRecordByTenant(
            @RequestParam("tenant_id") String tenant_id
    ){
        return hosingRecordsService.queryHousingRecordByTenant(Integer.parseInt(tenant_id));
    }

    @RequestMapping(value = "/QueryHousingRecordByTenant",method = RequestMethod.GET)
    @ResponseBody
    public List<HousingRecords> queryAllHousingRecord(){
        return hosingRecordsService.queryAllHousingRecord();
    }

}
