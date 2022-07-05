package com.hotelpms.service.Impl;

import com.hotelpms.mapper.RoomInfoMapper;
import com.hotelpms.mapper.RoomTypeMapper;
import com.hotelpms.pojo.RoomInfo;
import com.hotelpms.pojo.RoomType;
import com.hotelpms.service.RoomInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomInfoServiceImpl implements RoomInfoService {

    @Autowired
    RoomInfoMapper roomInfoMapper;
    @Autowired
    RoomTypeMapper roomTypeMapper;

    @Override
    public List<RoomInfo> queryAllRoom() {
        return roomInfoMapper.queryAll();
    }

    @Override
    public RoomInfo queryRoomInfoById(int id){
        return roomInfoMapper.queryById(id);
    }

    @Override
    public RoomInfo queryRoomInfoByRoomNumber(int roomNumber){
        return null;
    }

    @Override
    public List<RoomInfo> queryRoomInfoByType(int type){
        RoomType roomType = roomTypeMapper.queryById(type);
        String typename = roomType.getName();
        return roomInfoMapper.queryByTypeName(typename);

    }

    @Override
    public List<RoomInfo> queryRoomInfoByStatus(String status){
        return roomInfoMapper.queryByStatus(status);
    }


    @Override
    public List<RoomInfo> queryAllRoomByBuilding(String building) {
        return roomInfoMapper.queryByBuilding(building);
    }

    @Override
    public List<RoomInfo> queryAllRoomByBuildingAndFloor(String building, String floor) {
        return roomInfoMapper.queryByBuildingAndFloor(building , floor);
    }

    @Override
    public boolean addRoomInfo(int id , int room_num ,int type ,
                               String state , String building , String floor){
        if(roomTypeMapper.queryById(id) == null) {
            RoomType roomType = roomTypeMapper.queryById(type);
            RoomInfo roomInfo = new RoomInfo(id, room_num, roomType,
                    state, building, floor);
            roomInfoMapper.addRoomInfo(roomInfo);
            return true;
        }return false;
    }

    @Override
    public boolean updateRoomInfo(int id , int room_num ,int type,
                                  String state , String building , String floor) {
        RoomType roomType = roomTypeMapper.queryById(type);
        RoomInfo roomInfo = new RoomInfo(id , room_num , roomType ,
                state , building , floor);
        roomInfoMapper.updateRoomInfo(roomInfo);
        return true;
    }

    @Override
    public boolean deleteRoomInfoById(int id) {
        if(roomTypeMapper.queryById(id) != null) {
            roomInfoMapper.deleteRoomInfo(id);
            return true;
        }return false;
    }
}
