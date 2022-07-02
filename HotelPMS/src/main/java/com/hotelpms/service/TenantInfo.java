package com.hotelpms.service;

import com.hotelpms.pojo.RoomType;

public interface TenantInfo {

    boolean addTenantInfo(TenantInfo tenantInfo);

    boolean deleteTenantInfo(int id);

    boolean updateTenantInfo(TenantInfo tenantInfo);

    RoomType queryTenantInfo(int id);

    RoomType queryTenantInfoByName(String name);

    RoomType queryAllTenantInfo();

}
