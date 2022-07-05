package com.hotelpms.service.Impl;

import com.hotelpms.mapper.RoomTypeMapper;
import com.hotelpms.pojo.RoomType;
import com.hotelpms.service.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

//通过集成测使
@Service
public class RoomTypeServiceImpl implements RoomTypeService {

    @Autowired
    RoomTypeMapper roomTypeMapper;

    @Override
    public boolean addRoomType(int id, String name, BigDecimal price,
                               int bed_number, int max_people, String min_time) {
        if (roomTypeMapper.queryById(id) == null) {
            RoomType roomType = new RoomType(id, name, price,
                    bed_number, max_people, min_time);
            roomTypeMapper.addRoomType(roomType);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteRoomTypeById(int id) {
        if (roomTypeMapper.queryById(id) != null) {
            roomTypeMapper.deleteRoomType(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateRoomType(int id, String name, BigDecimal price,
                                  int bed_number, int max_people, String min_time) {
        if (roomTypeMapper.queryById(id) != null){
            RoomType roomType = new RoomType(id, name, price,
                    bed_number, max_people, min_time);
            roomTypeMapper.updateRoomType(roomType);
            return true;
        }
        return false;
    }

    @Override
    public RoomType queryRoomTypeById(int id) {
        return roomTypeMapper.queryById(id);
    }

    @Override
    public RoomType queryRoomTypeByName(String name) {
        return roomTypeMapper.queryByName(name);
    }

    @Override
    public List<RoomType> queryAllRoomType() {
        return roomTypeMapper.queryAll();
    }

    @Override
    public List<RoomType> queryRoomTypeByPrice(BigDecimal min_price,BigDecimal max_price){
        return null;
    }

    @Override
    public List<RoomType> queryRoomTypeByMaxPeople(int max_people){
        return null;
    }

    @Override
    public List<RoomType> queryRoomTypeByMinTime(String min_time){
        return null;
    }


    @Override
    public List<RoomType> queryRoomTypeByBedNum(int bed_num){
        return null;
    }



}