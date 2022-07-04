package com.hotelpms.service.Impl;

import com.hotelpms.mapper.StoreRecordsMapper;
import com.hotelpms.pojo.StoreRecords;
import com.hotelpms.service.StoreRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class StoreRecordsServiceImpl implements StoreRecordsService {

    @Autowired
    StoreRecordsMapper storeRecordsMapper;

    @Override
    public StoreRecords queryStoreRecords(int id) {
        return storeRecordsMapper.queryStoreRecordsById(id);
    }

    @Override
    public StoreRecords queryStoreRecordsByName(String name) {
        return storeRecordsMapper.queryStoreRecordsByName(name);
    }

    @Override
    public List<StoreRecords> queryAllStoreRecords() {
        return storeRecordsMapper.queryAllStoreRecords();
    }

    @Override
    public boolean addStoreRecords(int id, String name, int amount, BigDecimal price) {
        if(storeRecordsMapper.queryStoreRecordsById(id) == null){
            StoreRecords storeRecords = new StoreRecords( id , name , amount , price );
            storeRecordsMapper.addStoreRecords(storeRecords);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteStoreRecords(int id) {
        if(storeRecordsMapper.queryStoreRecordsById(id) != null){
            return true;
        }
        return false;
    }

    @Override
    public boolean updateStoreRecords(int id, String name, int amount, BigDecimal price) {
        StoreRecords storeRecords = new StoreRecords( id , name , amount , price );
        storeRecordsMapper.updateStoreRecords(storeRecords);
        return false;
    }
}
