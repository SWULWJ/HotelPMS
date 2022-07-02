package com.hotelpms.controller;

import com.hotelpms.pojo.RoomInfo;
import com.hotelpms.service.Impl.RoomInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public class RoomInfoController {

    @Autowired
    private RoomInfoServiceImpl roomInfoService;

    @RequestMapping(value = "/addRoomInfo",method = RequestMethod.GET)
    @ResponseBody
    public String addRoomInfo(
            @RequestParam("id") int id,
            @RequestParam("room_num") int room_num,
            @RequestParam("type") int type,
            @RequestParam("state") String state,
            @RequestParam("building") String building,
            @RequestParam("floor") String floor

    ){
        if (roomInfoService.addRoomInfo(id,room_num,type,state,building,floor))
            return "Success";
        return "Failed";
    }


    @RequestMapping(value = "/UpdateRoomInfo",method = RequestMethod.GET)
    @ResponseBody
    public String updateRoomInfo(
            @RequestParam("id") int id,
            @RequestParam("room_num") int room_num,
            @RequestParam("type") int type,
            @RequestParam("state") String state,
            @RequestParam("building") String building,
            @RequestParam("floor") String floor

    ){
        if (roomInfoService.updateRoomInfo(id,room_num,type,state,building,floor))
            return "Success";
        return "Failed";
    }

    @RequestMapping(value = "/DeleteRoomInfoById",method = RequestMethod.GET)
    @ResponseBody
    public String deleteRoomInfoById(
            @RequestParam("id") int id
    ){
        if (roomInfoService.deleteRoomInfoById(id))
            return "Success";
        return "Failed";
    }

    @RequestMapping(value = "/QueryRoomInfoById",method = RequestMethod.GET)
    @ResponseBody
    public RoomInfo queryRoomInfoById(
            @RequestParam("id") int id
    ){
        return roomInfoService.queryRoomInfoById(id);
    }

    @RequestMapping(value = "/QueryRoomInfoByRoomId",method = RequestMethod.GET)
    @ResponseBody
    public RoomInfo queryRoomInfoByRoomId(
            @RequestParam("room_id") int room_id
    ){
        return roomInfoService.queryRoomInfoByRoomId(room_id);
    }

    @RequestMapping(value = "/QueryRoomInfoByType",method = RequestMethod.GET)
    @ResponseBody
    public List<RoomInfo> queryRoomInfoByType(
            @RequestParam("type") int type
    ){
        return roomInfoService.queryRoomInfoByType(type);
    }

    @RequestMapping(value = "/QueryRoomInfoByStatus",method = RequestMethod.GET)
    @ResponseBody
    public List<RoomInfo> queryRoomInfoByStatus(
            @RequestParam("status") String status
    ){
        return roomInfoService.queryRoomInfoByStatus(status);
    }

    @RequestMapping(value = "/QueryAllRoomByBuilding",method = RequestMethod.GET)
    @ResponseBody
    public List<RoomInfo> queryAllRoomByBuilding(
            @RequestParam("building") String building
    ){
        return roomInfoService.queryAllRoomByBuilding(building);
    }

    @RequestMapping(value = "/QueryAllRoomByBuildingAndFloor",method = RequestMethod.GET)
    @ResponseBody
    public List<RoomInfo> queryAllRoomByBuildingAndFloor(
            @RequestParam("building") String building,
            @RequestParam("floor") String floor

    ){
        return roomInfoService.queryAllRoomByBuildingAndFloor(building,floor);
    }

    @RequestMapping(value = "/QueryAllRoom",method = RequestMethod.GET)
    @ResponseBody
    public List<RoomInfo> queryAllRoom(){
        return roomInfoService.queryAllRoom();
    }

}
