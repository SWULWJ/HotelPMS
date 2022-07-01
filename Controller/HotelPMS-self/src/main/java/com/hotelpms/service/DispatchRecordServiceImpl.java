package com.hotelpms.service;

import com.hotelpms.pojo.DispatchRecords;

import java.util.Date;
import java.util.List;

public class DispatchRecordServiceImpl implements DispatchRecordService{
    @Override
    public boolean addDispatchRecord(int id, int staff_id, String location, Date start_time, Date end_time, String type, String details) {
        return false;
    }

    @Override
    public boolean deleteDispatchRecordById(int id) {
        return false;
    }

    @Override
    public boolean updateDispatchRecord(int id, int staff_id, String location, Date start_time, Date end_time, String type, String details) {
        return false;
    }

    @Override
    public DispatchRecords queryDispatchRecordById(int id) {
        return null;
    }

    @Override
    public List<DispatchRecords> queryDispatchRecordByTime(Date start, Date end) {
        return null;
    }

    @Override
    public List<DispatchRecords> queryDispatchRecordByStaffId(int staff_id) {
        return null;
    }

    @Override
    public List<DispatchRecords> queryDispatchRecordByPosition(String position) {
        return null;
    }

    @Override
    public List<DispatchRecords> queryDispatchRecordByType(String type) {
        return null;
    }

    @Override
    public List<DispatchRecords> queryAllDispatchRecord() {
        return null;
    }
}
