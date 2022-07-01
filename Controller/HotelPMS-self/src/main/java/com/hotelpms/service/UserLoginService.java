package com.hotelpms.service;

import com.hotelpms.mapper.UserAccountMapper;
import com.hotelpms.pojo.RoomInfo;
import com.hotelpms.pojo.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserLoginService {

    @Autowired
    UserAccountMapper userAccountMapper;

    public boolean login_judge(String username,String password){
        if (userAccountMapper.queryUserAccountByAccount(username).getAccount()!=null){
            if (userAccountMapper.queryUserAccountByAccount(username).equals(password))
                return true;
        }
        return false;
    }

    public List<RoomInfo> getAllRoomIf(){
        List<RoomInfo> roomInfos = null;
        return roomInfos;
    }
}

