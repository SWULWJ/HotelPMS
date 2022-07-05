package com.hotelpms.service;

import com.hotelpms.pojo.DispatchRecords;

import java.util.Date;
import java.util.List;

public interface DispatchRecordService {

    //增
    //增加一条派遣记录
    boolean addDispatchRecord(int id, int staff_id, String location, Date start_time,Date end_time,String type,String details);

    //删
    //根据ID删除一条记录
    boolean deleteDispatchRecordById(int id);

    //改
    //修改一条记录
    boolean updateDispatchRecord(int id, int staff_id, String location, Date start_time,Date end_time,String type,String details);

    //查
    //根据ID查询一条派遣记录
    DispatchRecords queryDispatchRecordById(int id);
    //根据员工编号查询派遣记录
    List<DispatchRecords> queryDispatchRecordByStaffNumber( int staffNumber);
    //根据时段查询派遣记录
    List<DispatchRecords> queryDispatchRecordByTime(Date start,Date end);
    //根据员工ID查询派遣记录
    List<DispatchRecords> queryDispatchRecordByStaffId(int staff_id);
    //根据位置查询派遣记录
    List<DispatchRecords> queryDispatchRecordByPosition(String position);
    //根据类型查看派遣记录
    List<DispatchRecords> queryDispatchRecordByType(String type);
    //查看所有派遣记录
    List<DispatchRecords> queryAllDispatchRecord();

}
