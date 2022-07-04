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

//    @RequestMapping(value = "/addRoomInfo",method = RequestMethod.GET)
//    @ResponseBody
//    public String addRoomInfo(
//            @RequestParam("id") int id,
//            @RequestParam("room_num") int room_num,
//            @RequestParam("type") int type,
//            @RequestParam("state") String state,
//            @RequestParam("building") String building,
//            @RequestParam("floor") String floor
//
//    ){
//        if (roomInfoService.addRoomInfo(id,room_num,type,state,building,floor))
//            return "success";
//        return "failed";
//    }

    @RequestMapping(value = "/addRoomInfo",method = RequestMethod.GET)
    @ResponseBody
    public String addRoomInfo(
            @RequestParam("id") String id,
            @RequestParam("room_num") String room_num,
            @RequestParam("type") String type,
            @RequestParam("state") String state,
            @RequestParam("building") String building,
            @RequestParam("floor") String floor

    ){
        if (roomInfoService.addRoomInfo(Integer.parseInt(id),
                Integer.parseInt(room_num),Integer.parseInt(type),state,building,floor))
            return "success";
        return "failed";
    }

//    @RequestMapping(value = "/updateRoomInfo",method = RequestMethod.GET)
//    @ResponseBody
//    public String updateRoomInfo(
//            @RequestParam("id") int id,
//            @RequestParam("room_num") int room_num,
//            @RequestParam("type") int type,
//            @RequestParam("state") String state,
//            @RequestParam("building") String building,
//            @RequestParam("floor") String floor
//
//    ){
//        if (roomInfoService.updateRoomInfo(id,room_num,type,state,building,floor))
//            return "success";
//        return "failed";
//    }

    @RequestMapping(value = "/updateRoomInfo",method = RequestMethod.GET)
    @ResponseBody
    public String updateRoomInfo(
            @RequestParam("id") String id,
            @RequestParam("room_num") String room_num,
            @RequestParam("type") String type,
            @RequestParam("state") String state,
            @RequestParam("building") String building,
            @RequestParam("floor") String floor

    ){
        if (roomInfoService.updateRoomInfo(Integer.parseInt(id),
                Integer.parseInt(room_num),Integer.parseInt(type),state,building,floor))
            return "success";
        return "failed";
    }

//    @RequestMapping(value = "/deleteRoomInfoById",method = RequestMethod.GET)
//    @ResponseBody
//    public String deleteRoomInfoById(
//            @RequestParam("id") int id
//    ){
//        if (roomInfoService.deleteRoomInfoById(id))
//            return "success";
//        return "failed";
//    }

    @RequestMapping(value = "/deleteRoomInfoById",method = RequestMethod.GET)
    @ResponseBody
    public String deleteRoomInfoById(
            @RequestParam("id") String id
    ){
        if (roomInfoService.deleteRoomInfoById(Integer.parseInt(id)))
            return "success";
        return "failed";
    }

//    @RequestMapping(value = "/QueryRoomInfoById",method = RequestMethod.GET)
//    @ResponseBody
//    public RoomInfo queryRoomInfoById(
//            @RequestParam("id") int id
//    ){
//        return roomInfoService.queryRoomInfoById(id);
//    }

    @RequestMapping(value = "/QueryRoomInfoById",method = RequestMethod.GET)
    @ResponseBody
    public RoomInfo queryRoomInfoById(
            @RequestParam("id") String id
    ){
        return roomInfoService.queryRoomInfoById(Integer.parseInt(id));
    }

//    @RequestMapping(value = "/QueryRoomInfoByRoomId",method = RequestMethod.GET)
//    @ResponseBody
//    public RoomInfo queryRoomInfoByRoomNumber(
//            @RequestParam("room_id") int room_id
//    ){
//        return roomInfoService.queryRoomInfoByRoomNumber(room_id);
//    }

    @RequestMapping(value = "/queryRoomInfoByRoomId",method = RequestMethod.GET)
    @ResponseBody
    public RoomInfo queryRoomInfoByRoomId(
            @RequestParam("roomId") String room_id
    ){
        return roomInfoService.queryRoomInfoByRoomNumber(Integer.parseInt(room_id));
    }

//    @RequestMapping(value = "/queryRoomInfoByType",method = RequestMethod.GET)
//    @ResponseBody
//    public List<RoomInfo> queryRoomInfoByType(
//            @RequestParam("type") int type
//    ){
//        return roomInfoService.queryRoomInfoByType(type);
//    }

    @RequestMapping(value = "/queryRoomInfoByType",method = RequestMethod.GET)
    @ResponseBody
    public List<RoomInfo> queryRoomInfoByType(
            @RequestParam("type") String type
    ){
        return roomInfoService.queryRoomInfoByType(Integer.parseInt(type));
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
