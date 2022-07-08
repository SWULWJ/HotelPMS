package com.hotelpms.service;

import com.hotelpms.pojo.TenantInfo;
import com.hotelpms.pojo.TenantRoomRecords;

import java.util.List;

public interface TenantRoomRecordsService {

    //改
    //根据ID查询住客房屋
    TenantRoomRecords queryTenantRoomRecordsById(int i);
    //查询所有住客房屋
    List<TenantRoomRecords> queryAllTenantRoomRecords();
    //根据用户ID查询
    List<TenantRoomRecords> queryTenantRoomRecordsByTenantId(int tenant_id);

    //增
    //增加一个住客房屋
    boolean addTenantRoomRecords(int id, int tenant_id , int room_id);

    //删
    //根据id删除一个住客房屋
    boolean deleteTenantRoomRecords(int i);

    //改
    //更新一个住客房屋
    boolean updateTenantRoomRecords(int id, int tenant_id , int room_id );
}
