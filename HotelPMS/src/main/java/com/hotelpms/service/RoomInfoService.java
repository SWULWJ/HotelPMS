package com.hotelpms.service;

import com.hotelpms.pojo.RoomInfo;
import com.hotelpms.pojo.RoomType;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface RoomInfoService {
//    //增
//    //增加一条信息
//    boolean addRoomInfo(int id, int room_num,int type, String state, String building, String floor);
//
//    //删
//    //根据ID删除一条信息
//    boolean deleteRoomInfoById(int id);
//
//    //改
//    //更新一条信息
//    boolean updateRoomInfo(int id, int room_num,int type, String state, String building, String floor);
//
//    //查
//    //根据ID查询一条信息
//    RoomInfo queryRoomInfoById(int id);
//    //根据房间号查询信息
//    RoomInfo queryRoomInfoByRoomId(int room_id);
//    //查询某一类型的房间的所有信息
//    List<RoomInfo> queryRoomInfoByType(int type);
//    //查询某一状态的房间的所有信息
//    List<RoomInfo> queryRoomInfoByStatus(String status);
//    //查询某栋楼的所有房间的信息
//    List<RoomInfo> queryAllRoomByBuilding(String building);
//    //查询某栋楼的某一层的所有房间的信息
//    List<RoomInfo> queryAllRoomByBuildingAndFloor(String building,String floor);
//    //查询所有信息
//    List<RoomInfo> queryAllRoom();

    //查询所有属性（包括成员的属性）

    List<RoomInfo> queryAll();

    //通过房间类型的名称查询所有属性（包括成员的属性）
    List<RoomInfo> queryByTypeName(String typeName);

    //通过房间状态查询所有属性（包括成员的属性）

    List<RoomInfo> queryByStatus(String status);

    //通过楼栋号查询所有属性（包括成员的属性）

    List<RoomInfo> queryByBuilding(String building);

    //通过楼栋号和楼层号查询所有属性（包括成员的属性）

    List<RoomInfo> queryByBuildingAndFloor(String building, String floor);

    //根据ID查询房间信息记录
    RoomInfo queryById(int id);

    //新增一个房间信息记录
    void addRoomInfo(RoomInfo roomInfo);

    //根据ID更新房间信息记录

    void updateRoomInfo(RoomInfo roomInfo);

    //根据ID删除房间信息记录
    void deleteRoomInfo(int id);


}
