package com.hotelpms.mapper;

import com.hotelpms.pojo.UserAccount;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserAccountMapper {
    int addUserAccount(UserAccount userAccount);

    //通过id删除账号
    int deleteUserAccountById(int id);

    //更新账号
    int updateUserAccount(UserAccount userAccount);

    //通过id查找账号信息
    UserAccount queryUserAccountById(int id);

    //查找所有账号
    List<UserAccount> queryAllUserAccount();

    //通过账号查找账号信息
    UserAccount queryUserAccountByAccount(String account);
}
