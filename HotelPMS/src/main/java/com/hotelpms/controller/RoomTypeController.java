package com.hotelpms.controller;

import com.hotelpms.pojo.RoomType;
import com.hotelpms.service.Impl.RoomTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

public class RoomTypeController {

    @Autowired
    private RoomTypeServiceImpl roomTypeService;

    //
    @RequestMapping(value = "/AddRoomType",method = RequestMethod.GET)
    @ResponseBody
    public String addRoomType(
            @RequestParam("id") int id,
            @RequestParam("name") String name,
            @RequestParam("price") BigDecimal price,
            @RequestParam("bed_number") int bed_number,
            @RequestParam("max_people") int max_people,
            @RequestParam("min_time") String min_time
    ){
        id = 999;
        name = "小瘪三";

        if(roomTypeService.addRoomType(id, name, price, bed_number, max_people, min_time))
            return "Success";
        return "Failed";
    }

    @RequestMapping(value = "/UpdateRoomType",method = RequestMethod.GET)
    @ResponseBody
    public String updateRoomType(
            @RequestParam("id") int id,
            @RequestParam("name") String name,
            @RequestParam("price") BigDecimal price,
            @RequestParam("bed_number") int bed_number,
            @RequestParam("max_people") int max_people,
            @RequestParam("min_time") String min_time
    ){
        if(roomTypeService.updateRoomType(id, name, price, bed_number, max_people, min_time))
            return "Success";
        return "Failed";
    }

    @RequestMapping(value = "/DeleteRoomTypeById",method = RequestMethod.GET)
    @ResponseBody
    public String deleteRoomTypeById(
            @RequestParam("id") int id
    ){
        if(roomTypeService.deleteRoomTypeById(id))
            return "Success";
        return "Failed";
    }

    @RequestMapping(value = "/QueryRoomTypeById",method = RequestMethod.GET)
    @ResponseBody
    public RoomType queryRoomTypeById(
            @RequestParam("id") int id
    ){
        return roomTypeService.queryRoomTypeById(id);
    }

    @RequestMapping(value = "/QueryRoomTypeByPrice",method = RequestMethod.GET)
    @ResponseBody
    public List<RoomType> queryRoomTypeByPrice(
            @RequestParam("min_price") BigDecimal min_price,
            @RequestParam("max_price") BigDecimal max_price
    ){
        return roomTypeService.queryRoomTypeByPrice(min_price,max_price);
    }

    @RequestMapping(value = "/QueryRoomTypeByMaxPeople",method = RequestMethod.GET)
    @ResponseBody
    public List<RoomType> queryRoomTypeByMaxPeople(
            @RequestParam("max_people") int max_people
    ){
        return roomTypeService.queryRoomTypeByMaxPeople(max_people);
    }

    @RequestMapping(value = "/QueryRoomTypeByMinTime",method = RequestMethod.GET)
    @ResponseBody
    public List<RoomType> queryRoomTypeByMinTime(
            @RequestParam("min_time") String min_time
    ){
        return roomTypeService.queryRoomTypeByMinTime(min_time);
    }

    @RequestMapping(value = "/QueryRoomTypeByBedNum",method = RequestMethod.GET)
    @ResponseBody
    public List<RoomType> queryRoomTypeByBedNum(
            @RequestParam("bed_num") int bed_num
    ){
        return roomTypeService.queryRoomTypeByBedNum(bed_num);
    }

    @RequestMapping(value = "/QueryAllRoomType",method = RequestMethod.GET)
    @ResponseBody
    public List<RoomType> queryAllRoomType(){
        return roomTypeService.queryAllRoomType();
    }
}
