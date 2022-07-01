package com.hotelpms.service;

import com.hotelpms.pojo.TenantInfo;
import com.hotelpms.pojo.TenantRoom;

import java.util.List;

public interface TenantRoomService {

    //改
    //根据ID查询住客房屋
    boolean queryTenantRoomById(int i);
    //查询所有住客房屋
    List<TenantRoom> queryAllTenantRoom();
    //根据用户ID查询
    List<TenantRoom> queryTenantRoomByTenantId(int tenant_id);

    //增
    //增加一个住客房屋
    boolean addTenantRoom(int id,int tenant_id ,int room_id);

    //删
    //根据id删除一个住客房屋
    boolean deleteTenantRoom(int i);

    //改
    //更新一个住客房屋
    boolean updateTenantRoom(int id,int tenant_id ,int room_id );
}
