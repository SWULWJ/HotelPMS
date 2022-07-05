package com.hotelpms.service;

import com.hotelpms.mapper.UserAccountMapper;
import com.hotelpms.pojo.RoomInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserLoginService {

    @Autowired
    UserAccountMapper userAccountMapper;

    public boolean login_judge(String username,String password){
        if (userAccountMapper.queryByAccount(username).getAccount()!=null){
            if (userAccountMapper.queryByAccount(username).getPassword().equals(password))
                return true;
        }
        return false;
    }

    public List<RoomInfo> getAllRoomIf(){
        List<RoomInfo> roomInfos = null;
        return roomInfos;
    }
}

