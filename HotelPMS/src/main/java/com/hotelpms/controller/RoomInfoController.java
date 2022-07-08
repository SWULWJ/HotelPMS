package com.hotelpms.controller;

import com.hotelpms.pojo.RoomInfo;
import com.hotelpms.service.Impl.RoomInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
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


    // 增加一条房间信息
    // 输入: id, roomNum, type, state, building, floor
    // 输出: success or failed
    @RequestMapping(value = "/addRoomInfo",method = RequestMethod.GET)
    @ResponseBody
    public String addRoomInfo(
            @RequestParam("id") String id,
            @RequestParam("roomNum") String room_num,
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

    // 更新一条房间信息
    // 输入: id, roomNum, type, state, building, floor
    // 输出: success or failed
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


    // 删除一条房间信息
    // 输入: id
    // 输出: success or failed
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


    // 根据 id 查询一条房间信息
    // 输入: id
    // 输出: List<RoomInfo>
    @RequestMapping(value = "/queryRoomInfoById",method = RequestMethod.GET)
    @ResponseBody
    public List<RoomInfo> queryRoomInfoById(
            @RequestParam("id") String id
    ){
        List<RoomInfo> list = new ArrayList<>();
        list.add(roomInfoService.queryRoomInfoById(Integer.parseInt(id)));
        return list;
    }

//    @RequestMapping(value = "/QueryRoomInfoByRoomId",method = RequestMethod.GET)
//    @ResponseBody
//    public RoomInfo queryRoomInfoByRoomNumber(
//            @RequestParam("room_id") int room_id
//    ){
//        return roomInfoService.queryRoomInfoByRoomNumber(room_id);
//    }

    // 根据 roomId 查询一条房间信息
    // 输入: id
    // 输出: List<RoomInfo>
    @RequestMapping(value = "/queryRoomInfoByRoomId",method = RequestMethod.GET)
    @ResponseBody
    public List<RoomInfo> queryRoomInfoByRoomId(
            @RequestParam("roomNumber") String roomNumber
    ){
        List<RoomInfo> list = new ArrayList<>();
        list.add(roomInfoService.queryRoomInfoByRoomNumber(Integer.parseInt(roomNumber)));
        return list;
    }

//    @RequestMapping(value = "/queryRoomInfoByType",method = RequestMethod.GET)
//    @ResponseBody
//    public List<RoomInfo> queryRoomInfoByType(
//            @RequestParam("type") int type
//    ){
//        return roomInfoService.queryRoomInfoByType(type);
//    }

    // 根据 type 查询一条房间信息
    // 输入: type
    // 输出: List<RoomInfo>
    @RequestMapping(value = "/queryRoomInfoByType",method = RequestMethod.GET)
    @ResponseBody
    public List<RoomInfo> queryRoomInfoByType(
            @RequestParam("type") String type
    ){
        return roomInfoService.queryRoomInfoByType(Integer.parseInt(type));
    }

    // 根据 status 查询一条房间信息
    // 输入: status
    // 输出: List<RoomInfo>
    @RequestMapping(value = "/queryRoomInfoByStatus",method = RequestMethod.GET)
    @ResponseBody
    public List<RoomInfo> queryRoomInfoByStatus(
            @RequestParam("status") String status
    ){
        return roomInfoService.queryRoomInfoByStatus(status);
    }


    // 根据 building 查询一条房间信息
    // 输入: building
    // 输出: List<RoomInfo>
    @RequestMapping(value = "/queryAllRoomByBuilding",method = RequestMethod.GET)
    @ResponseBody
    public List<RoomInfo> queryAllRoomByBuilding(
            @RequestParam("building") String building
    ){
        return roomInfoService.queryAllRoomByBuilding(building);
    }


    // 根据 building 和 floor 查询一条房间信息
    // 输入: building, floor
    // 输出: List<RoomInfo>
    @RequestMapping(value = "/queryAllRoomByBuildingAndFloor",method = RequestMethod.GET)
    @ResponseBody
    public List<RoomInfo> queryAllRoomByBuildingAndFloor(
            @RequestParam("building") String building,
            @RequestParam("floor") String floor

    ){
        return roomInfoService.queryAllRoomByBuildingAndFloor(building,floor);
    }


    // 查询所有房间信息
    // 输入: 无
    // 输出: List<RoomInfo>
    @RequestMapping(value = "/queryAllRoom",method = RequestMethod.GET)
    @ResponseBody
    public List<RoomInfo> queryAllRoom(){
        return roomInfoService.queryAllRoom();
    }

}
