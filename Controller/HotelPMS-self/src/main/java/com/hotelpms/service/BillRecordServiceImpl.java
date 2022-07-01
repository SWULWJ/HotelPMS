package com.hotelpms.service;

import com.hotelpms.pojo.BillRecord;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class BillRecordServiceImpl implements BillRecordService{

    @Override
    public BillRecord QueryRecordById(int i) {
        return null;
    }

    @Override
    public List<BillRecord> QueryRecordByTime(Date start, Date end) {
        return null;
    }

    @Override
    public List<BillRecord> QueryRecordByStaffId(int id) {
        return null;
    }

    @Override
    public List<BillRecord> QueryRecordByType(String type) {
        return null;
    }

    @Override
    public List<BillRecord> QueryRecordByAmount(BigDecimal min, BigDecimal max) {
        return null;
    }

    @Override
    public List<BillRecord> QueryAllRecord() {
        return null;
    }

    @Override
    public boolean addBillRecord(int id, int bill_number, int stuff_id, String type, Date date, BigDecimal amount, String details, boolean auditing) {
        return false;
    }

    @Override
    public boolean deleteBillRecord(int id) {
        return false;
    }

    @Override
    public boolean updateBillRecord(int id, int bill_number, int stuff_id, String type, Date date, BigDecimal amount, String details, boolean auditing) {
        return false;
    }
}
