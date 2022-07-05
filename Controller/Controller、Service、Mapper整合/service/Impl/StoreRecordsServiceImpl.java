package com.hotelpms.service.Impl;

import com.hotelpms.mapper.StoreRecordsMapper;
import com.hotelpms.pojo.StoreRecords;
import com.hotelpms.service.StoreRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

//通过后端集成测试
@Service
public class StoreRecordsServiceImpl implements StoreRecordsService {

    @Autowired
    StoreRecordsMapper storeRecordsMapper;

    @Override
    public StoreRecords queryStoreRecordsById(int id) {
        return storeRecordsMapper.queryById(id);
    }

    @Override
    public StoreRecords queryStoreRecordsByName(String name){
        return storeRecordsMapper.queryByName(name);
    }

    @Override
    public List<StoreRecords> queryAllStoreRecords() {
        return storeRecordsMapper.queryAll();
    }

    @Override
    public boolean addStoreRecords(int id, String name, int amount, BigDecimal price) {
        if(storeRecordsMapper.queryById(id) == null){
            StoreRecords storeRecords = new StoreRecords(id, name, amount, price );
            storeRecordsMapper.addStoreRecords(storeRecords);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteStoreRecords(int id) {
        if(storeRecordsMapper.queryById(id) != null){
            storeRecordsMapper.deleteStoreRecords(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateStoreRecords(int id , String name , int amount , BigDecimal price) {
        StoreRecords storeRecords = new StoreRecords( id , name , amount , price );
        storeRecordsMapper.updateStoreRecords(storeRecords);
        return true;
    }
}
