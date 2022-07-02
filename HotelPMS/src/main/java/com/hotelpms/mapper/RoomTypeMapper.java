package com.hotelpms.mapper;


import com.hotelpms.pojo.RoomType;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RoomTypeMapper {

    //新增一个房间类型
    @Insert("INSERT INTO room_type(name,price,bed_number,max_people,min_time) "
            +"VALUES(#{name},#{price},#{bedNumber},#{maxPeople},#{minTime})")
    void addRoomType(RoomType roomType);

    //通过id删除一个房间类型
    @Delete("DELETE FROM room_type WHERE id=#{id}")
    void deleteRoomType(int id);

    //更新一个房间类型
    @Update("UPDATE room_type "
            +"SET name=#{name},price=#{price},bed_number=#{bedNumber},max_people=#{maxPeople},min_time=#{minTime} "
            +"WHERE id=#{id}")
    void updateRoomType(RoomType roomType);

    //通过id查找一个房间类型
    @Select("SELECT * FROM room_type WHERE id=#{id}")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "name", property = "name"),
            @Result(column = "price", property = "price"),
            @Result(column = "bed_number", property = "bedNumber"),
            @Result(column = "max_people", property = "maxPeople"),
            @Result(column = "min_time", property = "minTime")
    })
    RoomType queryRoomTypeById(int id);

    //通过房间类型名称查找一个房间类型
    @Select("SELECT * FROM room_type WHERE name=#{name}")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "name", property = "name"),
            @Result(column = "price", property = "price"),
            @Result(column = "bed_number", property = "bedNumber"),
            @Result(column = "max_people", property = "maxPeople"),
            @Result(column = "min_time", property = "minTime")
    })
    RoomType queryRoomTypeByName(String name);

    //查找所有房间类型
    @Select("SELECT * FROM room_type")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "name", property = "name"),
            @Result(column = "price", property = "price"),
            @Result(column = "bed_number", property = "bedNumber"),
            @Result(column = "max_people", property = "maxPeople"),
            @Result(column = "min_time", property = "minTime")
    })
    List<RoomType> queryAllRoomType();
}
