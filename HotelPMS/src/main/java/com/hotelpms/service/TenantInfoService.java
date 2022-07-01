package com.hotelpms.service;

import com.hotelpms.pojo.TenantInfo;

import java.util.List;

public interface TenantInfoService {

    //改
    //根据ID查询住客
     TenantInfo queryTenantInfoById(int i);
    //查询所有住客
    List<TenantInfo> queryAllTenantInfo();

    //增
    //增加一个住客信息
    boolean addTenantInfo(int id,String name,String gender,String id_card);

    //删
    //根据id删除一个账单
    boolean deleteTenantInfo(int i);

    //改
    //更新一个住客信息
    boolean updateTenantInfo(int id,String name,String gender,String id_card)  ;
}
