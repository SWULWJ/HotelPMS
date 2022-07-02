package com.hotelpms.mapper;

import com.hotelpms.pojo.StoreRecords;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StoreRecordsMapper {

    //新增一条库存记录
    @Insert("INSERT INTO store_records(name, amount, price) "
            +"VALUES(#{name}, #{amount}, #{price})")
    void addStoreRecords(StoreRecords storeRecords);

    //通过id删除一条库存记录
    @Delete("DELETE FROM store_records WHERE id=#{id}")
    void deleteStoreRecords(int id);

    //更新一条库存记录
    @Update("UPDATE store_records "
            +"SET name=#{name}, amount=#{amount}, price=#{price} "
            +"WHERE id=#{id}")
    void updateStoreRecords(StoreRecords storeRecords);

    //通过id查找一条库存记录
    @Select("SELECT * FROM store_records WHERE id=#{id}")
    StoreRecords queryStoreRecordsById(int id);

    //通过物品名称查找一条库存记录
    @Select("SELECT * FROM store_records WHERE name=#{name}")
    StoreRecords queryStoreRecordsByName(String name);

    //查找所有库存记录
    @Select("SELECT * FROM store_records")
    List<StoreRecords> queryAllStoreRecords();

}