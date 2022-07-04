package com.hotelpms.service;

import com.hotelpms.pojo.TenantInfo;

import java.util.List;

public interface TenantInfoService {

    //查
    //根据ID查询住客
    TenantInfo queryTenantInfoById(int id);
    //根据姓名查询住客
    List<TenantInfo> queryTenantInfoByName(String name);
    //查询所有住客
    List<TenantInfo> queryAllTenantInfo();

    //增
    //增加一个住客信息
    boolean addTenantInfo(int id,String name,String gender,String id_card);

    //删
    //根据id删除一个账单
    boolean deleteTenantInfo(int id);

    //改
    //更新一个住客信息
    boolean updateTenantInfo(int id,String name,String gender,String id_card)  ;
}
