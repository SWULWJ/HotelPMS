package com.hotelpms.service.finish;

import com.hotelpms.mapper.RoomInfoMapper;
import com.hotelpms.pojo.RoomInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RoomInfoServiceImpl implements RoomInfoService{

    @Autowired
    RoomInfoMapper roomInfoMapper;

    @Override
    public List<RoomInfo> queryAll() {
        return roomInfoMapper.queryAll();
    }

    @Override
    public List<RoomInfo> queryByTypeName(String typeName) {
        return roomInfoMapper.queryByTypeName(typeName);
    }

    @Override
    public List<RoomInfo> queryByStatus(String status) {
        return roomInfoMapper.queryByStatus(status);
    }

    @Override
    public List<RoomInfo> queryByBuilding(String building) {
        return roomInfoMapper.queryByBuilding(building);
    }

    @Override
    public List<RoomInfo> queryByBuildingAndFloor(String building, String floor) {
        return roomInfoMapper.queryByBuildingAndFloor(building , floor);
    }

    @Override
    public RoomInfo queryById(int id){
        return roomInfoMapper.queryById(id);
    }

    @Override
    public void addRoomInfo(RoomInfo roomInfo) {
        roomInfoMapper.addRoomInfo(roomInfo);

    }

    @Override
    public void updateRoomInfo(RoomInfo roomInfo) {
        roomInfoMapper.updateRoomInfo(roomInfo);
    }

    @Override
    public void deleteRoomInfo(int id) {
         roomInfoMapper.deleteRoomInfo(id);
    }
}
