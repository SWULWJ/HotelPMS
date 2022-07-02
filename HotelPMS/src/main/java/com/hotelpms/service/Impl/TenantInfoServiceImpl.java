package com.hotelpms.service.Impl;

import com.hotelpms.pojo.TenantInfo;
import com.hotelpms.service.TenantInfoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TenantInfoServiceImpl implements TenantInfoService {
    @Override
    public TenantInfo queryTenantInfoById(int id) {
        return null;
    }

    @Override
    public List<TenantInfo> queryAllTenantInfo() {
        return null;
    }

    @Override
    public boolean addTenantInfo(int id, String name, String gender, String id_card) {
        return false;
    }

    @Override
    public boolean deleteTenantInfo(int id) {
        return false;
    }

    @Override
    public boolean updateTenantInfo(int id, String name, String gender, String id_card) {
        return false;
    }
}
