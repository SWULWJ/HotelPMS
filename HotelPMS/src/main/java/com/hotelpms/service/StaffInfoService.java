package com.hotelpms.service;

import com.hotelpms.pojo.StaffInfo;

import java.util.List;

public interface StaffInfoService {
    // 增加一条员工信息
    boolean addStaff(int id,int staffNum,String name,String gender,int age,String position,String tel);

    // 通过id删除一条员工信息
    boolean deleteStaffInfoById(int id);

    // 更新一个员工的所有信息
    boolean updateStaffInfo(int id,int staffNum,String name,String gender,int age,String position,String tel);

    // 通过id查询一条员工信息
    StaffInfo queryStaffInfoById(int id);


    // 查询所有员工信息
    List<StaffInfo> queryAllStaffInfo();

}
