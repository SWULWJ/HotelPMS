package com.hotelpms.service;

import com.hotelpms.pojo.StoreRecords;

import java.math.BigDecimal;
import java.util.List;

public interface StoreRecordsService {

    //根据ID查询库存
    StoreRecords queryStoreRecordsById(int id);

    //通过物品名称查找一条库存记录
    StoreRecords queryStoreRecordsByName(String name);

    //查询所有库存
    List<StoreRecords> queryAllStoreRecords();

    //增加一个库存记录
    boolean addStoreRecords(int id, String name, int amount, BigDecimal price);

    //根据ID删除一个库存记录
    boolean deleteStoreRecords(int id);

    //更新一条库存
    boolean updateStoreRecords(int id, String name, int amount, BigDecimal price);



}
