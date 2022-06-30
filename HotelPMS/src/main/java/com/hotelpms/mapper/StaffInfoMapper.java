package com.hotelpms.mapper;

import com.hotelpms.pojo.StaffInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StaffInfoMapper {
    //新增一个员工信息
    int addStaffInfo(StaffInfo staffInfo);

    //通过id删除一个员工信息
    int deleteStaffInfo(int id);

    //更新员工信息
    int updateStaffInfo(StaffInfo staffInfo);

    //通过id查找员工信息
    StaffInfo queryStaffInfoById(int id);

    //查找所有员工信息
    List<StaffInfo> queryAllStaffInfo();

}
