package com.hotelpms.service;

import com.hotelpms.mapper.UserAccountMapper;
import com.hotelpms.pojo.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService {

    @Autowired
    UserAccountMapper userAccountMapper;

    public boolean addUser(int id,  int staffId, String account, String password) {
        if (userAccountMapper.queryUserAccountById(id).getAccount() == null) {
            UserAccount userAccount = new UserAccount(id, staffId, account, password);
            userAccountMapper.addUserAccount(userAccount);
            return true;
        }
        return false;
    }

    public boolean updateUser(int id,  int staffId, String account, String password) {
        if (userAccountMapper.queryUserAccountById(id) != null){
            UserAccount userAccount = new UserAccount(id, staffId, account, password);
            userAccountMapper.addUserAccount(userAccount);
            return true;
        }
        return false;
    }
}
