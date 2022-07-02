package com.hotelpms.service.Impl;

import com.hotelpms.pojo.StoreRecords;
import com.hotelpms.service.StoreRecordsService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class StoreRecordsServiceImpl implements StoreRecordsService {
    @Override
    public StoreRecords queryStoreRecords(int id) {
        return null;
    }

    @Override
    public List<StoreRecords> queryAllStoreRecords() {
        return null;
    }

    @Override
    public boolean addStoreRecords(int id, String name, int amount, BigDecimal price) {
        return false;
    }

    @Override
    public boolean deleteStoreRecords(int id) {
        return false;
    }

    @Override
    public boolean updateStoreRecords(int id, String name, int amount, BigDecimal price) {
        return false;
    }
}
