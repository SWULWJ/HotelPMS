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
            +"SET staff_number=#{staffNumber}, name=#{name}, gender=#{gender}, age=#{age}, position=#{position}, tel=#{tel} "
            +"WHERE id=#{id}")
    void updateStaffInfo(StaffInfo staffInfo);

    //通过id查找员工信息
    @Select("SELECT * FROM staff_info WHERE id=#{id}")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "staff_number", property = "staffNumber"),
            @Result(column = "name", property = "name"),
            @Result(column = "gender", property = "gender"),
            @Result(column = "age", property = "age"),
            @Result(column = "position", property = "position"),
            @Result(column = "tel", property = "tel")
    })
    StaffInfo queryById(int id);
    
    // 通过姓名查询所有重名的员工信息
    @Select("SELECT * FROM staff_info WHERE name=#{name}")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "staff_number", property = "staffNumber"),
            @Result(column = "name", property = "name"),
            @Result(column = "gender", property = "gender"),
            @Result(column = "age", property = "age"),
            @Result(column = "position", property = "position"),
            @Result(column = "tel", property = "tel")
    })
    List<StaffInfo> queryByName(String name);
    
    //查找所有员工信息
    @Select("SELECT * FROM staff_info")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "staff_number", property = "staffNumber"),
            @Result(column = "name", property = "name"),
            @Result(column = "gender", property = "gender"),
            @Result(column = "age", property = "age"),
            @Result(column = "position", property = "position"),
            @Result(column = "tel", property = "tel")
    })
    List<StaffInfo> queryAll();
    
    // 通过员工编号查询一条员工信息
    @Select("SELECT * FROM staff_info WHERE staff_number=#{staffNumber}")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "staff_number", property = "staffNumber"),
            @Result(column = "name", property = "name"),
            @Result(column = "gender", property = "gender"),
            @Result(column = "age", property = "age"),
            @Result(column = "position", property = "position"),
            @Result(column = "tel", property = "tel")
    })
    StaffInfo queryByStaffNumber(int staffNumber);
}
