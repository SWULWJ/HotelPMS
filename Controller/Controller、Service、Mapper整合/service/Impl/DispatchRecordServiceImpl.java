package com.hotelpms.service.Impl;

import com.hotelpms.mapper.DispatchRecordsMapper;
import com.hotelpms.pojo.DispatchRecords;
import com.hotelpms.pojo.StaffInfo;
import com.hotelpms.service.DispatchRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DispatchRecordServiceImpl implements DispatchRecordService {
    

    @Autowired
    DispatchRecordsMapper dispatchRecordsMapper;


    @Override
    public List<DispatchRecords> queryAllDispatchRecord(){
        return dispatchRecordsMapper.queryAll();
    }

    @Override
    public DispatchRecords queryDispatchRecordById(int id) {
        return dispatchRecordsMapper.queryById(id);
    }

   
    @Override
    public List<DispatchRecords> queryDispatchRecordByStaffNumber( int staffNumber) {
        return dispatchRecordsMapper.queryByStaffNumber(staffNumber);
    }

    @Override
    public boolean addDispatchRecord(int id, StaffInfo staffInfo , String location, Date start_time, Date end_time, String type, String details){
        return true;
    }

    //删
    //根据ID删除一条记录
    public boolean deleteDispatchRecordById(int id){
        return true;
    }


    //改
    //修改一条记录
    public boolean updateDispatchRecord(int id, int staff_id, String location, Date start_time,Date end_time,String type,String details){
        return true;
    }


    //根据时段查询派遣记录
    public List<DispatchRecords> queryDispatchRecordByTime(Date start,Date end){
        return null;
    }
    //根据员工ID查询派遣记录
    public List<DispatchRecords> queryDispatchRecordByStaffId(int staff_id){
        return null;
    }

    //根据位置查询派遣记录
    public List<DispatchRecords> queryDispatchRecordByPosition(String position){
        return null;
    }

    //根据类型查看派遣记录
    public List<DispatchRecords> queryDispatchRecordByType(String type){
        return null;
    }
   
}
