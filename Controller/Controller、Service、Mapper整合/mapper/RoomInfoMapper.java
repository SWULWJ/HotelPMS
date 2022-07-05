package com.hotelpms.mapper;

import com.hotelpms.pojo.RoomInfo;
import com.hotelpms.pojo.RoomType;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RoomInfoMapper {
	//查询所有属性（包括成员的属性）
	@Select("SELECT * FROM room_info")
	@Results({
			@Result(column = "id", property = "id"),
			@Result(column = "room_number", property = "roomNumber"),
			@Result(column = "state", property = "state"),
			@Result(column = "building", property = "building"),
			@Result(column = "floor", property = "floor"),
			@Result(
					column = "type",
					property = "roomType",
					javaType = RoomType.class,
					one = @One(select = "com.hotelpms.mapper.RoomTypeMapper.queryById")
			)
	})
	List<RoomInfo> queryAll();
	
	//通过房间类型的名称查询所有属性（包括成员的属性）
	@Select("SELECT i.id iid, t.id tid, room_number, state, building, floor, "
			+"name, price, bed_number, max_people, min_time "
			+"FROM room_info i, room_type t "
			+"WHERE type=t.id AND name=#{typeName}")
	@Results({
			@Result(column = "iid", property = "id"),
			@Result(column = "room_number", property = "roomNumber"),
			@Result(column = "state", property = "state"),
			@Result(column = "building", property = "building"),
			@Result(column = "floor", property = "floor"),
			@Result(column = "tid", property = "roomType.id"),
			@Result(column = "name", property = "roomType.name"),
			@Result(column = "price", property = "roomType.price"),
			@Result(column = "bed_number", property = "roomType.bedNumber"),
			@Result(column = "max_people", property = "roomType.maxPeople"),
			@Result(column = "min_time", property = "roomType.minTime")
	})
	List<RoomInfo> queryByTypeName(String typeName);
	
	//通过房间状态查询所有属性（包括成员的属性）
	@Select("SELECT * FROM room_info WHERE state=#{status}")
	@Results({
			@Result(column = "id", property = "id"),
			@Result(column = "room_number", property = "roomNumber"),
			@Result(column = "state", property = "state"),
			@Result(column = "building", property = "building"),
			@Result(column = "floor", property = "floor"),
			@Result(
					column = "type",
					property = "roomType",
					javaType = RoomType.class,
					one = @One(select = "com.hotelpms.mapper.RoomTypeMapper.queryById")
			)
	})
	List<RoomInfo> queryByStatus(String status);
	
	//通过楼栋号查询所有属性（包括成员的属性）
	@Select("SELECT * FROM room_info WHERE building=#{building}")
	@Results({
			@Result(column = "id", property = "id"),
			@Result(column = "room_number", property = "roomNumber"),
			@Result(column = "state", property = "state"),
			@Result(column = "building", property = "building"),
			@Result(column = "floor", property = "floor"),
			@Result(
					column = "type",
					property = "roomType",
					javaType = RoomType.class,
					one = @One(select = "com.hotelpms.mapper.RoomTypeMapper.queryById")
			)
	})
	List<RoomInfo> queryByBuilding(String building);
	
	//通过楼栋号和楼层号查询所有属性（包括成员的属性）
	@Select("SELECT * FROM room_info WHERE building=#{building} AND floor=#{floor}")
	@Results({
			@Result(column = "id", property = "id"),
			@Result(column = "room_number", property = "roomNumber"),
			@Result(column = "state", property = "state"),
			@Result(column = "building", property = "building"),
			@Result(column = "floor", property = "floor"),
			@Result(
					column = "type",
					property = "roomType",
					javaType = RoomType.class,
					one = @One(select = "com.hotelpms.mapper.RoomTypeMapper.queryById")
			)
	})
	List<RoomInfo> queryByBuildingAndFloor(String building, String floor);
	
	//新增一个房间信息记录
	@Insert("INSERT INTO room_info(room_number, type, state, building, floor) "
			+"VALUES(#{roomNumber}, #{roomType.id}, #{state}, #{building}, #{floor})")
	void addRoomInfo(RoomInfo roomInfo);
	
	//根据ID更新房间信息记录
	@Update("UPDATE room_info "
			+"SET room_number=#{roomNumber}, type=#{roomType.id} ,state=#{state} ,building=#{building} ,floor=#{floor} "
			+"WHERE id=#{id}")
	void updateRoomInfo(RoomInfo roomInfo);
	
	//根据ID删除房间信息记录
	@Delete("DELETE FROM room_info WHERE id=#{id}")
	void deleteRoomInfo(int id);
	
	//通过id查询
	@Select("SELECT * FROM room_info WHERE id=#{id}")
	@Results({
			@Result(column = "id", property = "id"),
			@Result(column = "room_number", property = "roomNumber"),
			@Result(column = "state", property = "state"),
			@Result(column = "building", property = "building"),
			@Result(column = "floor", property = "floor"),
			@Result(
					column = "type",
					property = "roomType",
					javaType = RoomType.class,
					one = @One(select = "com.hotelpms.mapper.RoomTypeMapper.queryById")
			)
	})
	RoomInfo queryById(int id);
}
