package com.hotelpms.service.finish;

import com.hotelpms.pojo.StaffInfo;

import java.util.List;

public interface StaffInfoService {
    // 增加一条员工信息
    boolean addStaff(int id,int sn,String name,String gender,int age,String pos,String tel);

    // 通过id删除一条员工信息
    boolean deleteStaffInfo(int id);

    // 更新一个员工的所有信息
    boolean updateStaffInfo(int id,int staffNum,String name,String gender,int age,String pos,String tel);

    // 通过id查询一条员工信息
    StaffInfo queryStaffInfoById(int id);

    // 通过姓名查询所有重名的员工信息
    List<StaffInfo> queryStaffInfoByName(String name);

    // 查询所有员工信息
    List<StaffInfo> queryAllStaffInfo();

    //通过员工编号查询员工
    StaffInfo queryStaffInfoByStaffNumber(int staffNumber);

}
