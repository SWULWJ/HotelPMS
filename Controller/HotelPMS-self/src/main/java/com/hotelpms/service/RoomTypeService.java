package com.hotelpms.service;

import com.hotelpms.pojo.RoomType;

import java.math.BigDecimal;
import java.util.List;

public interface RoomTypeService {
    //增
    //增加一条数据
    boolean addRoomType(int id, int name, BigDecimal price,int bed_number,int max_people,String min_time);

    //删
    //根据ID删除一条信息
    boolean deleteRoomTypeById(int id);

    //改
    //修改一条数据
    boolean updateRoomType(int id, int name, BigDecimal price,int bed_number,int max_people,String min_time);

    //查
    //根据ID查询一条信息
    RoomType queryRoomTypeById(int id);
    //根据价格区间信息
    List<RoomType> queryRoomTypeByPrice(BigDecimal min_price,BigDecimal max_price);
    //根据人数查询所有信息
    List<RoomType> queryRoomTypeByMaxPeople(int max_people);
    //根据最短时间查询信息
    List<RoomType> queryRoomTypeByMinTime(String min_time);
    //根据床数查询信息
    List<RoomType> queryRoomTypeByBedNum(int bed_num);
}
