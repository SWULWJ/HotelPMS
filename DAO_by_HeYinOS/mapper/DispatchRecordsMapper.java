package com.hotelpms.mapper;

import com.hotelpms.pojo.DispatchRecords;
import com.hotelpms.pojo.StaffInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DispatchRecordsMapper {
	//通过id查询所有属性（包含成员的属性）
	@Select("SELECT * FROM dispatch_records WHERE id=#{id}")
	@Results({
			@Result(column = "id", property = "id"),
			@Result(column = "location", property = "location"),
			@Result(column = "start_time", property = "startTime"),
			@Result(column = "end_time", property = "endTime"),
			@Result(column = "type", property = "type"),
			@Result(column = "details", property = "details"),
			@Result(
					column = "staff_id",
					property = "staffInfo",
					javaType = StaffInfo.class,
					one = @One(select = "com.hotelpms.mapper.StaffInfoMapper.queryStaffInfoById")
			)
	})
	DispatchRecords queryAllById(int id);
	
	
	//通过员工的staff_number查询所有属性（包含成员的属性）
	@Select("SELECT d.id did, s.id sid, location, start_time, end_time, type, details, "
			+"staff_number, name, gender, age, position, tel "
			+"FROM dispatch_records d, staff_info s "
			+"WHERE s.staff_number=#{staffNumber}")
	@Results({
			@Result(column = "did", property = "id"),
			@Result(column = "location", property = "location"),
			@Result(column = "start_time", property = "startTime"),
			@Result(column = "end_time", property = "endTime"),
			@Result(column = "type", property = "type"),
			@Result(column = "details", property = "details"),
			@Result(column = "sid", property = "staffInfo.id"),
			@Result(column = "staff_number", property = "staffInfo.staffNumber"),
			@Result(column = "name", property = "staffInfo.name"),
			@Result(column = "gender", property = "staffInfo.gender"),
			@Result(column = "age", property = "staffInfo.age"),
			@Result(column = "position", property = "staffInfo.position"),
			@Result(column = "tel", property = "staffInfo.tel")
			
	})
	List<DispatchRecords> queryAllByStaffNumber(int staffNumber);
}
