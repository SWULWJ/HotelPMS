package com.hotelpms.service;

import com.hotelpms.pojo.RoomType;
import com.hotelpms.pojo.StoreRecords;

public interface StoreRecordsService {

    boolean addStoreRecords(StoreRecords storeRecords);

    boolean deleteStoreRecords(int id);

    boolean updateStoreRecords(StoreRecords storeRecords);

    RoomType queryStoreRecords(int id);

    RoomType queryStoreRecordsByName(String name);

    RoomType queryAllStoreRecords();

}
