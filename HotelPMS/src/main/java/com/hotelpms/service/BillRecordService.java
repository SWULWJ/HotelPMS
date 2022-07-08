package com.hotelpms.service;

import com.hotelpms.pojo.BillRecord;

import javax.xml.crypto.Data;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface BillRecordService {

    //查
    //根据ID查询账单
    BillRecord QueryRecordById(int i);
    //根据时间查询信息
    List<BillRecord> QueryRecordByTime(Date start,Date end);
    //根据员工查询信息
    List<BillRecord> QueryRecordByStaffId(int id);
    //根据类型查询
    List<BillRecord> QueryRecordByType(String type);
    //根据数额查询
    List<BillRecord> QueryRecordByAmount(BigDecimal min,BigDecimal max);
    //根据审计信息查询
    List<BillRecord> QueryRecordByAuditing(boolean Auditing);
    //查询所有账单
    List<BillRecord> QueryAllRecord();

    //增
    //增加一个账单
    boolean addBillRecord(int id, int bill_number, int stuff_id, String type, Date date, BigDecimal amount, String details, boolean auditing);

    //删
    //根据ID删除一个账单
    boolean deleteBillRecord(int id);

    //改
    //更新一条数据
    boolean updateBillRecord(int id, int bill_number, int stuff_id, String type, Date date,BigDecimal amount,String details,boolean auditing);

    //更新审计信息
    boolean updateAuditing(int id);




}
