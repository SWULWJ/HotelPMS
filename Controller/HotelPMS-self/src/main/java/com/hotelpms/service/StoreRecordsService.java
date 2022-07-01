package com.hotelpms.service;

import com.hotelpms.pojo.StoreRecords;

import java.math.BigDecimal;
import java.util.List;

public interface StoreRecordsService {

    //查
    //根据ID查询商店
    StoreRecords queryStoreRecords(int i);
    //查询所有账单
    List<StoreRecords> queryAllStoreRecords();

    //增
    //增加一个商店记录
    boolean addStoreRecords(int id, String name, int amount, BigDecimal price);

    //删
    //根据ID删除一个商店记录
    boolean deleteStoreRecords(int id);

    //改
    //更新一条商店记录
    boolean updateStoreRecords(int id, String name, int amount, BigDecimal price);



}
