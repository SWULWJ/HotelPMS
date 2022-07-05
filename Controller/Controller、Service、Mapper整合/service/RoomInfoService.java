package com.hotelpms.service;

import com.hotelpms.pojo.RoomInfo;

import java.util.List;

public interface RoomInfoService {
    //增
    //增加一条信息
    boolean addRoomInfo(int id, int room_num,int type, String state, String building, String floor);

    //删
    //根据ID删除一条信息
    boolean deleteRoomInfoById(int id);

    //改
    //更新一条信息
    boolean updateRoomInfo(int id, int room_num,int type, String state, String building, String floor);

    //查
    //根据ID查询一条信息
    RoomInfo queryRoomInfoById(int id);
    //根据房间号查询信息
    RoomInfo queryRoomInfoByRoomNumber(int roomNumber);
    //查询某一类型的房间的所有信息
    List<RoomInfo> queryRoomInfoByType(int type);
    //查询某一状态的房间的所有信息
    List<RoomInfo> queryRoomInfoByStatus(String status);
    //查询某栋楼的所有房间的信息
    List<RoomInfo> queryAllRoomByBuilding(String building);
    //查询某栋楼的某一层的所有房间的信息
    List<RoomInfo> queryAllRoomByBuildingAndFloor(String building,String floor);
    //查询所有信息
    List<RoomInfo> queryAllRoom();
}
