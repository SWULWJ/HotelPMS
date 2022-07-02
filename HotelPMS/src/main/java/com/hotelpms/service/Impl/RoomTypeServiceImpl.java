package com.hotelpms.service.Impl;

import com.hotelpms.pojo.RoomType;
import com.hotelpms.service.RoomTypeService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class RoomTypeServiceImpl implements RoomTypeService {
    @Override
    public boolean addRoomType(int id, int name, BigDecimal price, int bed_number, int max_people, String min_time) {
        return false;
    }

    @Override
    public boolean deleteRoomTypeById(int id) {
        return false;
    }

    @Override
    public boolean updateRoomType(int id, int name, BigDecimal price, int bed_number, int max_people, String min_time) {
        return false;
    }

    @Override
    public RoomType queryRoomTypeById(int id) {
        return null;
    }

    @Override
    public List<RoomType> queryRoomTypeByPrice(BigDecimal min_price, BigDecimal max_price) {
        return null;
    }

    @Override
    public List<RoomType> queryRoomTypeByMaxPeople(int max_people) {
        return null;
    }

    @Override
    public List<RoomType> queryRoomTypeByMinTime(String min_time) {
        return null;
    }

    @Override
    public List<RoomType> queryRoomTypeByBedNum(int bed_num) {
        return null;
    }

    @Override
    public List<RoomType> queryAllRoomType() {
        return null;
    }
}
