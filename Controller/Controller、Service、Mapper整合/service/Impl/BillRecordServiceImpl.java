package com.hotelpms.service.Impl;

import com.hotelpms.mapper.BillRecordMapper;
import com.hotelpms.pojo.BillRecord;
import com.hotelpms.pojo.StaffInfo;
import com.hotelpms.service.BillRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
@Service
public class BillRecordServiceImpl implements BillRecordService {

    @Autowired
    BillRecordMapper billRecordMapper;
    @Autowired
    StaffInfoServiceImpl staffInfoService;

    @Override
    public BillRecord QueryRecordById(int i) {
        return billRecordMapper.queryById(i);
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
    public List<BillRecord> QueryRecordByAuditing(boolean Auditing){
        return billRecordMapper.queryByAuditing(Auditing);
    }

    @Override
    public List<BillRecord> QueryAllRecord() {
        return billRecordMapper.queryAll();
    }

    @Override
    public boolean addBillRecord(int id, int bill_number, int stuff_id, String type, Date date, BigDecimal amount, String details, boolean auditing) {
        if(billRecordMapper.queryById(id) != null){
            StaffInfo staffInfo = staffInfoService.queryStaffInfoById(stuff_id);
            BillRecord billRecord = new BillRecord( id , bill_number , staffInfo , type , date , amount , details , auditing);
            billRecordMapper.addBillRecord(billRecord);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteBillRecord(int id) {
        return false;
    }

    @Override
    public boolean updateBillRecord(int id, int bill_number, int stuff_id, String type, Date date, BigDecimal amount, String details, boolean auditing) {
        StaffInfo staffInfo = staffInfoService.queryStaffInfoById(stuff_id);

        BillRecord billRecord = new BillRecord( id , bill_number , staffInfo , type , date , amount , details , auditing);
        billRecordMapper.addBillRecord(billRecord);
        return true;

    }

    @Override
    public boolean updateAuditing(int id) {
        BillRecord billRecord = billRecordMapper.queryById(id);
        billRecordMapper.updateAuditing(billRecord);
        return true;
    }

}
