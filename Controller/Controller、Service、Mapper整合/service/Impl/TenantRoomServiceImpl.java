package com.hotelpms.service.Impl;

import com.hotelpms.pojo.TenantRoom;

import java.util.List;

public class TenantRoomServiceImpl implements TenantRoomService{
    @Override
    public TenantRoom queryTenantRoomById(int i) {
        return null;
    }

    @Override
    public List<TenantRoom> queryAllTenantRoom() {
        return null;
    }

    @Override
    public List<TenantRoom> queryTenantRoomByTenantId(int tenant_id) {
        return null;
    }

    @Override
    public boolean addTenantRoom(int id, int tenant_id, int room_id) {
        return false;
    }

    @Override
    public boolean deleteTenantRoom(int i) {
        return false;
    }

    @Override
    public boolean updateTenantRoom(int id, int tenant_id, int room_id) {
        return false;
    }
}
