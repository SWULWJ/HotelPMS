package com.hotelpms.mapper;

import com.hotelpms.pojo.BillRecord;
import com.hotelpms.pojo.StaffInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BillRecordMapper {
	//查询所有
	@Select("SELECT * FROM bill_record")
	@Results({
			@Result(column = "id", property = "id"),
			@Result(column = "bill_number", property = "billNumber"),
			@Result(column = "type", property = "type"),
			@Result(column = "time", property = "time"),
			@Result(column = "amount", property = "amount"),
			@Result(column = "details", property = "details"),
			@Result(column = "auditing", property = "auditing"),
			@Result(
					column = "staff_id",
					property = "staffInfo",
					javaType = StaffInfo.class,
					one = @One(select = "com.hotelpms.mapper.StaffInfoMapper.queryById")
			)
	})
	List<BillRecord> queryAll();
	
	//通过审计标志查询
	@Select("SELECT * FROM bill_record WHERE auditing=#{auditing}")
	@Results({
			@Result(column = "id", property = "id"),
			@Result(column = "bill_number", property = "billNumber"),
			@Result(column = "type", property = "type"),
			@Result(column = "time", property = "time"),
			@Result(column = "amount", property = "amount"),
			@Result(column = "details", property = "details"),
			@Result(column = "auditing", property = "auditing"),
			@Result(
					column = "staff_id",
					property = "staffInfo",
					javaType = StaffInfo.class,
					one = @One(select = "com.hotelpms.mapper.StaffInfoMapper.queryById")
			)
	})
	List<BillRecord> queryByAuditing(boolean auditing);
	
	//通过id查询
	@Select("SELECT * FROM bill_record WHERE id=#{id}")
	@Results({
			@Result(column = "id", property = "id"),
			@Result(column = "bill_number", property = "billNumber"),
			@Result(column = "type", property = "type"),
			@Result(column = "time", property = "time"),
			@Result(column = "amount", property = "amount"),
			@Result(column = "details", property = "details"),
			@Result(column = "auditing", property = "auditing"),
			@Result(
					column = "staff_id",
					property = "staffInfo",
					javaType = StaffInfo.class,
					one = @One(select = "com.hotelpms.mapper.StaffInfoMapper.queryById")
			)
	})
	BillRecord queryById(int id);
	
	//新增一个数据
	@Insert("INSERT INTO bill_record(bill_number, staff_id, type, time, amount, details, auditing) "
			+"VALUES(#{billNumber}, #{staffInfo.id}, #{type}, #{time}, #{amount}, #{details}, #{auditing})")
	void addBillRecord(BillRecord billRecord);
	
	//通过id修改审计标记
	@Update("UPDATE bill_record "
			+"SET auditing=#{auditing} "
			+"WHERE id=#{id}")
	void updateAuditing(BillRecord billRecord);
}
