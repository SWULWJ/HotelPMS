package com.hotelpms.mapper;


import com.hotelpms.pojo.RoomType;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface RoomTypeMapper {

    //新增一个房间类型
    void addRoomType(RoomType roomType);

    //通过id删除一个房间类型
    void deleteRoomType(int id);

    //更新一个房间类型
    void updateRoomType(RoomType roomType);

    //通过id查找一个房间类型
    RoomType queryRoomTypeById(int id);

    //通过房间类型名称查找一个房间类型
    RoomType queryRoomTypeByName();

    //查找所有房间类型
    RoomType queryAllRoomType();
}
