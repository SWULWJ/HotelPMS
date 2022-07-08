package com.hotelpms.service.Impl;

import com.hotelpms.pojo.TenantRoomRecords;
import com.hotelpms.service.TenantRoomRecordsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TenantRoomRecordsServiceImpl implements TenantRoomRecordsService {
    @Override
    public TenantRoomRecords queryTenantRoomRecordsById(int i) {
        return null;
    }

    @Override
    public List<TenantRoomRecords> queryAllTenantRoomRecords() {
        return null;
    }

    @Override
    public List<TenantRoomRecords> queryTenantRoomRecordsByTenantId(int tenant_id) {
        return null;
    }

    @Override
    public boolean addTenantRoomRecords(int id, int tenant_id, int room_id) {
        return false;
    }

    @Override
    public boolean deleteTenantRoomRecords(int i) {
        return false;
    }

    @Override
    public boolean updateTenantRoomRecords(int id, int tenant_id, int room_id) {
        return false;
    }
}
