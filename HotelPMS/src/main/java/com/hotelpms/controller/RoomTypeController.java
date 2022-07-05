package com.hotelpms.controller;

import com.hotelpms.pojo.RoomType;
import com.hotelpms.service.Impl.RoomTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@Controller
public class RoomTypeController {

    @Autowired
    private RoomTypeServiceImpl roomTypeService;

    //显示所有房间类型
    @GetMapping(value = "/queryAllRoomType")
    @ResponseBody
    public List<RoomType> queryAllRoomType() {
        return roomTypeService.queryAllRoomType();
    }

    //增加一个房间类型
    @GetMapping(value = "/addRoomType")
    @ResponseBody
    public String addRoomType(
            @RequestParam("id") String id,
            @RequestParam("name") String name,
            @RequestParam("price") String price,
            @RequestParam("bedNumber") String bedNumber,
            @RequestParam("maxPeople") String maxPeople,
            @RequestParam("minTime") String minTime
    ) {
        if(roomTypeService.addRoomType(Integer.parseInt(id),
                name, new BigDecimal(price), Integer.parseInt(bedNumber),
                Integer.parseInt(maxPeople), minTime))
            return "success";
        return "failed";
    }

    //更新一个房间类型
    @GetMapping(value = "/updateRoomType")
    @ResponseBody
    public String updateRoomType(
            @RequestParam("id") String id,
            @RequestParam("name") String name,
            @RequestParam("price") String price,
            @RequestParam("bedNumber") String bedNumber,
            @RequestParam("maxPeople") String maxPeople,
            @RequestParam("minTime") String minTime
    ) {
        if(roomTypeService.updateRoomType(Integer.parseInt(id),
                name, new BigDecimal(price), Integer.parseInt(bedNumber),
                Integer.parseInt(maxPeople), minTime))
            return "success";
        return "failed";
    }

    //删除一个房间类型
    @GetMapping(value = "/deleteRoomType")
    @ResponseBody
    public String deleteRoomTypeById(
            @RequestParam("id") String id
    ) {
        if(roomTypeService.deleteRoomTypeById(Integer.parseInt(id)))
            return "success";
        return "failed";
    }
}
