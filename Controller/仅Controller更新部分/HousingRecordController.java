package com.hotelpms.controller;

import com.hotelpms.pojo.HousingRecords;
import com.hotelpms.service.HousingRecordsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class HousingRecordController {

    @Autowired
    private HousingRecordsServiceImpl hosingRecordsService;

    @RequestMapping(value = "/AddHousingRecord",method = RequestMethod.GET)
    @ResponseBody
    public String addHousingRecord(
            @RequestParam("id") int id,
            @RequestParam("room_id") int room_id,
            @RequestParam("tenant_id") int tenant_id,
            @RequestParam("check_in_time") Date check_in_time,
            @RequestParam("check_out_time") Date check_out_time,
            @RequestParam("price")BigDecimal price
    ){
        if(hosingRecordsService.addHosingRecord(id,room_id,tenant_id,check_in_time,check_out_time,price))
            return "Success";
        return "Failed";
    }

    @RequestMapping(value = "/UpdateHousingRecord",method = RequestMethod.GET)
    @ResponseBody
    public String updateHousingRecord(
            @RequestParam("id") int id,
            @RequestParam("room_id") int room_id,
            @RequestParam("tenant_id") int tenant_id,
            @RequestParam("check_in_time") Date check_in_time,
            @RequestParam("check_out_time") Date check_out_time,
            @RequestParam("price")BigDecimal price
    ){
        if(hosingRecordsService.updateHousingRecord(id,room_id,tenant_id,check_in_time,check_out_time,price))
            return "Success";
        return "Failed";
    }

    @RequestMapping(value = "/DeleteHousingRecord",method = RequestMethod.GET)
    @ResponseBody
    public String deleteHousingRecord(
            @RequestParam("id") int id
    ){
        if (hosingRecordsService.deleteHousingRecordById(id))
            return "Success";
        return "Failed";
    }

    @RequestMapping(value = "/QueryHousingRecordById",method = RequestMethod.GET)
    @ResponseBody
    public HousingRecords queryHousingRecordById(
            @RequestParam("id") int id
    ){
        return hosingRecordsService.queryHousingRecordById(id);
    }

    @RequestMapping(value = "/QueryHousingRecordByTime",method = RequestMethod.GET)
    @ResponseBody
    public List<HousingRecords> queryHousingRecordByTime(
            @RequestParam("check_in_time") Date check_in_time,
            @RequestParam("check_out_time") Date check_out_time
    ){
        return hosingRecordsService.queryHousingRecordByTime(check_in_time,check_out_time);
    }

    @RequestMapping(value = "/QueryHousingRecordByTime",method = RequestMethod.GET)
    @ResponseBody
    public List<HousingRecords> queryHousingRecordByRoom(
            @RequestParam("room_id") int room_id
    ){
        return hosingRecordsService.queryHousingRecordByRoom(room_id);
    }

    @RequestMapping(value = "/QueryHousingRecordByTenant",method = RequestMethod.GET)
    @ResponseBody
    public List<HousingRecords> queryHousingRecordByTenant(
            @RequestParam("tenant_id") int tenant_id
    ){
        return hosingRecordsService.queryHousingRecordByTenant(tenant_id);
    }

    @RequestMapping(value = "/QueryHousingRecordByTenant",method = RequestMethod.GET)
    @ResponseBody
    public List<HousingRecords> queryAllHousingRecord(){
        return hosingRecordsService.queryAllHousingRecord();
    }

}
