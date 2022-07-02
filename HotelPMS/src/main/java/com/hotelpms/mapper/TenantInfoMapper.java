package com.hotelpms.mapper;

import com.hotelpms.pojo.RoomType;
import com.hotelpms.pojo.TenantInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface TenantInfoMapper {

    //新增一个房客信息
    void addTenantInfo(TenantInfo tenantInfo);

    //通过id删除一个房客信息
    void deleteTenantInfo(int id);

    //更新一个房客信息
    void updateTenantInfo(TenantInfo tenantInfo);

    //通过id查找一个房客信息
    RoomType queryTenantInfoById(int id);

    //通过房客姓名称查找一个房客信息
    RoomType queryTenantInfoByName();

    //查找所有房客信息
    RoomType queryAllTenantInfo();

}
