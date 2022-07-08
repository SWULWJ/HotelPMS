package com.hotelpms.service;

import com.hotelpms.pojo.StaffInfo;
import com.hotelpms.pojo.UserAccount;

import java.util.List;

public interface UserAccountService {

    public boolean addUser(int id, String account, String password, StaffInfo staffInfo);

    public boolean updateUser(int id, String account, String password, StaffInfo staffInfo);

    public UserAccount readUserById(int id);

    public List<UserAccount> readAllUser();

    public boolean deleteUserById(int id);

    public boolean loginJudge(String username,String password);
}
