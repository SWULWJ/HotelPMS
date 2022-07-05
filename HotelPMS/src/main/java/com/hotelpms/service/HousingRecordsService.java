package com.hotelpms.service;

import com.hotelpms.pojo.HousingRecords;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface HousingRecordsService {
    //增
    //增加一条记录
    boolean addHosingRecord(int id, int room_id, int tenant_id, Date check_in_time, Date check_out_time, BigDecimal price);

    //删
    //根据ID删除一条记录
    boolean deleteHousingRecordById(int id);
    //改
    //更新一条数据
    boolean updateHousingRecord(int id, int room_id, int tenant_id, Date check_in_time, Date check_out_time, BigDecimal price);

    //查
    //根据ID查询一条数据
    HousingRecords queryHousingRecordById(int id);
    //查询某一时段内的
    List<HousingRecords> queryHousingRecordByTime(Date check_in,Date check_out);
    //查询某一房间的记录
    List<HousingRecords> queryHousingRecordByRoom(int room_id);
    //查询某一旅客的记录
    List<HousingRecords> queryHousingRecordByTenant(int tenant_id);
    //查询所有记录
    List<HousingRecords> queryAllHousingRecord();
}
