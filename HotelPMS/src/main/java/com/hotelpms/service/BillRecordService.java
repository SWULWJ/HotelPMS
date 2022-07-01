package com.hotelpms.service;

import com.hotelpms.pojo.BillRecord;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

public interface BillRecordService {

    //查
    //根据ID查询账单
    BillRecord queryRecordById(int i);
    //查询所有账单
    List<BillRecord> queryAllRecord();

    //增
    //增加一个账单
    boolean addBillRecord(int id, int bill_number, int stuff_id, String type, Date date,int amount,String details,int auditing);

    //删
    //根据ID删除一个账单
    boolean deleteBillRecord(int id);

    //改
    //更新一条数据
    boolean updateBillRecord(int id, int bill_number, int stuff_id, String type, Date date,int amount,String details,int auditing);



}
