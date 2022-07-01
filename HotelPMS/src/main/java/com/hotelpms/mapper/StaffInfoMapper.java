package com.hotelpms.mapper;

import com.hotelpms.pojo.StaffInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StaffInfoMapper {
    //新增一个员工信息
    @Insert("INSERT INTO staff_info(staff_number, name, gender, age, position, tel) "
            +"VALUES (#{staffNumber}, #{name}, #{gender}, #{age}, #{position}, #{tel})")
    void addStaffInfo(StaffInfo staffInfo);

    //通过id删除一个员工信息
    @Delete("DELETE FROM staff_info WHERE id=#{id}")
    void deleteStaffInfo(int id);

    //更新员工信息
    @Update("UPDATE staff_info "
            +"SET name=#{name}, gender=#{gender}, age=#{age}, position=#{position}, tel=#{tel} "
            +"WHERE staff_number=#{staffNumber}")
    void updateStaffInfo(StaffInfo staffInfo);

    //通过id查找员工信息
    @Select("SELECT * FROM staff_info WHERE id=#{id}")
    StaffInfo queryStaffInfoById(int id);

    //查找所有员工信息
    @Select("SELECT * FROM staff_info")
    List<StaffInfo> queryAllStaffInfo();

}
