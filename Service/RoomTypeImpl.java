package com.hotelpms.service;

import com.hotelpms.mapper.RoomTypeMapper;
import com.hotelpms.pojo.RoomType;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;

public class RoomTypeImpl implements RoomTypeService{

    @Autowired
    RoomTypeMapper roomTypeMapper;

    @Override
    public boolean addRoomType(int id, String name, BigDecimal price,
                               int bed_number, int max_people, String min_time) {
        if (roomTypeMapper.queryRoomTypeById(id) == null) {
            RoomType roomType = new RoomType(id, name, price,
                    bed_number, max_people, min_time);
            roomTypeMapper.addRoomType(roomType);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteRoomType(int id) {
        if (roomTypeMapper.queryRoomTypeById(id) != null) {
            roomTypeMapper.deleteRoomType(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateRoomType(int id, String name, BigDecimal price,
                                  int bed_number, int max_people, String min_time) {
        if (roomTypeMapper.queryRoomTypeById(id) == null){
            RoomType roomType = new RoomType(id, name, price,
                    bed_number, max_people, min_time);
            roomTypeMapper.addRoomType(roomType);
            return true;
        }
        return false;
    }

    @Override
    public RoomType queryRoomTypeById(int id) {
        return roomTypeMapper.queryRoomTypeById(id);
    }

    @Override
    public RoomType queryRoomTypeByName(String name) {
        return roomTypeMapper.queryRoomTypeByName(name);
    }

    @Override
    public List<RoomType> queryAllRoomType() {
        return roomTypeMapper.queryAllRoomType();
    }
}
