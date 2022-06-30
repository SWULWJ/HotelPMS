package com.hotelpms.service;

import com.hotelpms.mapper.UserAccountMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class UserLoginService {

    @Autowired
    UserAccountMapper userAccountMapper;

    public boolean login_judge(String username,String password){
            if (userAccountMapper.queryUserAccountByAccount(username).getAccount()!=null){
                if (userAccountMapper.queryUserAccountByAccount(username).getPassword().equals(password))
                    return true;
            }
            return false;
        }

    }


