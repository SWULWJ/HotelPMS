package com.hotelpms.mapper;

import com.hotelpms.pojo.RoomInfo;
import com.hotelpms.pojo.TenantInfo;
import com.hotelpms.pojo.TenantRoomRecords;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TenantRoomRecordsMapper
{
	//通过房间id和active查询所有记录
	@Select("SELECT * FROM tenant_room_records WHERE room_id=#{roomId} AND active=#{active}")
	@Results({
			@Result(id = true, column = "id", property = "id"),
			@Result(column = "in_time", property = "inTime"),
			@Result(column = "out_time", property = "outTime"),
			@Result(column = "active", property = "active"),
			@Result(column = "booker", property = "booker"),
			@Result(column = "price", property = "price"),
			@Result(
					column = "tenant_id",
					property = "tenantInfo",
					javaType = TenantInfo.class,
					one = @One(select = "com.hotelpms.mapper.TenantInfoMapper.queryById")
			),
			@Result(
					column = "room_id",
					property = "roomInfo",
					javaType = RoomInfo.class,
					one = @One(select = "com.hotelpms.mapper.RoomInfoMapper.queryById")
			)
	})
	List<TenantRoomRecords> queryByRoomIdAndActive(int roomId, boolean active);
	
	//通过房间id查询所有记录
	@Select("SELECT * FROM tenant_room_records WHERE room_id=#{roomId}")
	@Results({
			@Result(id = true, column = "id", property = "id"),
			@Result(column = "in_time", property = "inTime"),
			@Result(column = "out_time", property = "outTime"),
			@Result(column = "active", property = "active"),
			@Result(column = "booker", property = "booker"),
			@Result(column = "price", property = "price"),
			@Result(
					column = "tenant_id",
					property = "tenantInfo",
					javaType = TenantInfo.class,
					one = @One(select = "com.hotelpms.mapper.TenantInfoMapper.queryById")
			),
			@Result(
					column = "room_id",
					property = "roomInfo",
					javaType = RoomInfo.class,
					one = @One(select = "com.hotelpms.mapper.RoomInfoMapper.queryById")
			)
	})
	List<TenantRoomRecords> queryByRoomId(int roomId);
	
	//通过房客id查询所有记录
	@Select("SELECT * FROM tenant_room_records WHERE tenant_id=#{tenantId}")
	@Results({
			@Result(id = true, column = "id", property = "id"),
			@Result(column = "in_time", property = "inTime"),
			@Result(column = "out_time", property = "outTime"),
			@Result(column = "active", property = "active"),
			@Result(column = "booker", property = "booker"),
			@Result(column = "price", property = "price"),
			@Result(
					column = "tenant_id",
					property = "tenantInfo",
					javaType = TenantInfo.class,
					one = @One(select = "com.hotelpms.mapper.TenantInfoMapper.queryById")
			),
			@Result(
					column = "room_id",
					property = "roomInfo",
					javaType = RoomInfo.class,
					one = @One(select = "com.hotelpms.mapper.RoomInfoMapper.queryById")
			)
	})
	List<TenantRoomRecords> queryByTenantId(int tenantId);
	
	//通过房间id更新active
	@Update("UPDATE tenant_room_records "
			+"SET active=#{active} "
			+"WHERE room_id=#{roomInfo.id}")
	void updateActive(TenantRoomRecords tenantRoomRecords);
	
	//新增入住记录
	@Insert("INSERT INTO tenant_room_records(tenant_id, room_id, in_time, out_time, active, booker, price) "
			+"VALUES(#{tenantInfo.id}, #{roomInfo.id}, #{inTime}, #{outTime}, #{active}, #{booker}, #{price})")
	void add(TenantRoomRecords tenantRoomRecords);
}
