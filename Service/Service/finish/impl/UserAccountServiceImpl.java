package com.hotelpms.service.finish;

import com.hotelpms.mapper.UserAccountMapper;
import com.hotelpms.pojo.StaffInfo;
import com.hotelpms.pojo.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAccountServiceImpl {

    @Autowired
    UserAccountMapper userAccountMapper;

    public boolean addUser(int id, String account, String password, StaffInfo staffInfo) {
        if (userAccountMapper.queryUserAccountById(id) == null) {
            UserAccount userAccount = new UserAccount(id,account, password,staffInfo);
            userAccountMapper.addUserAccount(userAccount);
            return true;
        }
        return false;
    }

    public boolean updateUser(int id, String account, String password, StaffInfo staffInfo) {
        if (userAccountMapper.queryUserAccountById(id) != null){
            UserAccount userAccount = new UserAccount(id,account, password,staffInfo);
            userAccountMapper.updateUserAccount(userAccount);
            return true;
        }
        return false;
    }

    public UserAccount readUserById(int id){
        return userAccountMapper.queryUserAccountById(id);
    }

    public List<UserAccount> readAllUser(){
        return userAccountMapper.queryAllUserAccount();
    }

    public boolean deleteUserById(int id){
        if(userAccountMapper.queryUserAccountById(id)!=null){
            userAccountMapper.deleteUserAccountById(id);
            return true;
        }
        return false;
    }
}
