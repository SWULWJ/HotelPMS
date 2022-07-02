package com.hotelpms.service;

import com.hotelpms.pojo.RoomType;

import java.math.BigDecimal;
import java.util.List;

public interface RoomTypeService {

    boolean addRoomType(int id, String name, BigDecimal price, int bed_number, int max_people, String min_time);

    boolean deleteRoomType(int id);

    boolean updateRoomType(int id, String name, BigDecimal price, int bed_number, int max_people, String min_time);

    RoomType queryRoomTypeById(int id);

    RoomType queryRoomTypeByName(String name);

    List<RoomType> queryAllRoomType();



}
