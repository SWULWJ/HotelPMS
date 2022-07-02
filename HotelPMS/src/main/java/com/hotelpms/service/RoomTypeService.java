package com.hotelpms.service;

import com.hotelpms.pojo.RoomType;

public interface RoomTypeService {

    boolean addRoomType(RoomType roomType);

    boolean deleteRoomType(int id);

    boolean updateRoomType(RoomType roomType);

    RoomType queryRoomTypeById(int id);

    RoomType queryRoomTypeByName(String name);

    RoomType queryAllRoomType();



}
