package com.hotelpms.mapper;

import com.hotelpms.pojo.RoomType;
import com.hotelpms.pojo.StoreRecords;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface StoreRecordsMapper {

    //新增一条库存记录
    void addStoreRecords(StoreRecords storeRecords);

    //通过id删除一条库存记录
    void deleteStoreRecords(int id);

    //更新一条库存记录
    void updateStoreRecords(StoreRecords storeRecords);

    //通过id查找一条库存记录
    RoomType queryStoreRecordsById(int id);

    //通过物品名称查找一条库存记录
    RoomType queryStoreRecordsByName();

    //查找所有库存记录
    RoomType queryAllStoreRecords();

}
