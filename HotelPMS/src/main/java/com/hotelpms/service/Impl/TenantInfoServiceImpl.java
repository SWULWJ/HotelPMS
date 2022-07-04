package com.hotelpms.service.Impl;

import com.hotelpms.mapper.TenantInfoMapper;
import com.hotelpms.pojo.TenantInfo;
import com.hotelpms.service.finish.TenantInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TenantInfoServiceImpl implements TenantInfoService {

    @Autowired
    TenantInfoMapper tenantInfoMapper;

    @Override
    public TenantInfo queryTenantInfoById(int id) {
        return tenantInfoMapper.queryTenantInfoById(id);
    }

    @Override
    public List<TenantInfo> queryTenantInfoByName(String name){
        return  tenantInfoMapper.queryTenantInfoByName(name);
    }

    @Override
    public List<TenantInfo> queryAllTenantInfo() {
        return tenantInfoMapper.queryAllTenantInfo();
    }

    @Override
    public boolean addTenantInfo(int id, String name,
                                 String gender, String id_card) {
        if(tenantInfoMapper.queryTenantInfoById(id) == null){
            TenantInfo tenantInfo = new TenantInfo( id , name ,
                    gender , id_card);
            tenantInfoMapper.addTenantInfo(tenantInfo);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteTenantInfo(int id) {
        if(tenantInfoMapper.queryTenantInfoById(id) != null){
            tenantInfoMapper.deleteTenantInfo(id);
        }
        return false;
    }

    @Override
    public boolean updateTenantInfo(int id, String name, String gender, String id_card) {
        TenantInfo tenantInfo = new TenantInfo( id , name ,
                gender , id_card);
        tenantInfoMapper.updateTenantInfo(tenantInfo);
        return false;
    }
}
