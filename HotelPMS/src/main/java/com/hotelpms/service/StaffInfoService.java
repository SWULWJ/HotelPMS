package com.hotelpms.service;

import com.hotelpms.pojo.StaffInfo;

import java.util.List;

public interface StaffInfoService {
    // 增加一条员工信息
    int addStaff(StaffInfo staffInfo);

    // 通过id删除一条员工信息
    int deleteStaffInfoById(int id);

    // 更新一个员工的所有信息
    int updateStaffInfo(StaffInfo staffInfo);

    // 通过id查询一条员工信息
    StaffInfo queryStaffInfoById(int id);

    // 通过姓名查询所有重名的员工信息
    List<StaffInfo> queryStaffInfoByName(String name);

    // 查询所有员工信息
    List<StaffInfo> queryAllStaffInfo();

}
