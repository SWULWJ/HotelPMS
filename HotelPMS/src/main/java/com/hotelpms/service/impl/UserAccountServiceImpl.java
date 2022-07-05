package com.hotelpms.service.Impl;

import com.hotelpms.mapper.UserAccountMapper;
import com.hotelpms.pojo.StaffInfo;
import com.hotelpms.pojo.UserAccount;
import com.hotelpms.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    @Autowired
    UserAccountMapper userAccountMapper;

    public boolean addUser(int id, String account, String password, StaffInfo staffInfo) {
        if (userAccountMapper.queryById(id) == null) {
            UserAccount userAccount = new UserAccount(id,account, password,staffInfo);
            userAccountMapper.addUserAccount(userAccount);
            return true;
        }
        return false;
    }

    public boolean updateUser(int id, String account, String password, StaffInfo staffInfo) {
        if (userAccountMapper.queryById(id) != null){
            UserAccount userAccount = new UserAccount(id,account, password,staffInfo);
            userAccountMapper.updateUserAccount(userAccount);
            return true;
        }
        return false;
    }

    public UserAccount readUserById(int id){
        return userAccountMapper.queryById(id);
    }

    public List<UserAccount> readAllUser(){
        return userAccountMapper.queryAll();
    }

    public boolean deleteUserById(int id){
        if(userAccountMapper.queryById(id)!=null){
            userAccountMapper.deleteUserAccount(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean loginJudge(String username, String password) {
        if (userAccountMapper.queryByAccount(username) != null && userAccountMapper.queryByAccount(username).getAccount() != null) {
            return userAccountMapper.queryByAccount(username).getPassword().equals(password);
        }
        return false;
    }
}
