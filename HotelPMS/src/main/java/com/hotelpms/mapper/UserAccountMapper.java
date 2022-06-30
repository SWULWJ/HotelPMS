package com.hotelpms.mapper;

import com.hotelpms.pojo.UserAccount;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserAccountMapper {
    int addUserAccount(UserAccount userAccount);

    int deleteUserAccountById(int id);

    int updateUserAccount(UserAccount userAccount);

    UserAccount queryUserAccountById(int id);

    List<UserAccount> queryAllUserAccount();

    //通过账号
    UserAccount queryUserAccountByAccount(String account);
}
