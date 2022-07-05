package com.hotelpms.mapper;

import com.hotelpms.pojo.StaffInfo;
import com.hotelpms.pojo.UserAccount;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserAccountMapper {
    //增加账号
    @Insert("INSERT INTO user_account(staff_id,account,password) "
            +"VALUES(#{staffInfo.id},#{account},#{password})")
    void addUserAccount(UserAccount userAccount);

    //通过id删除账号
    @Delete("DELETE FROM user_account WHERE id=#{id}")
    void deleteUserAccount(int id);

    //更新账号
    @Update("UPDATE user_account "
            +"SET account=#{account}, password=#{password} "
            +"WHERE id=#{id}")
    void updateUserAccount(UserAccount userAccount);

    //通过id查找账号信息
    @Select("SELECT * FROM user_account WHERE id=#{id}")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "account", property = "account"),
            @Result(column = "password", property = "password"),
            @Result(
                    column = "staff_id",
                    property = "staffInfo",
                    javaType = StaffInfo.class,
                    one = @One(select = "com.hotelpms.mapper.StaffInfoMapper.queryById")
            )
    })
    UserAccount queryById(int id);

    //查找所有账号
    @Select("SELECT * FROM user_account")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "account", property = "account"),
            @Result(column = "password", property = "password"),
            @Result(
                    column = "staff_id",
                    property = "staffInfo",
                    javaType = StaffInfo.class,
                    one = @One(select = "com.hotelpms.mapper.StaffInfoMapper.queryById")
            )
    })
    List<UserAccount> queryAll();

    //通过账号查找账号信息
    @Select("SELECT * FROM user_account WHERE account=#{account}")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "account", property = "account"),
            @Result(column = "password", property = "password"),
            @Result(
                    column = "staff_id",
                    property = "staffInfo",
                    javaType = StaffInfo.class,
                    one = @One(select = "com.hotelpms.mapper.StaffInfoMapper.queryById")
            )
    })
    UserAccount queryByAccount(String account);
    
    //通过staff_id寻找信息
    @Select("SELECT * FROM user_account WHERE staff_id=#{staffId}")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "account", property = "account"),
            @Result(column = "password", property = "password"),
            @Result(
                    column = "staff_id",
                    property = "staffInfo",
                    javaType = StaffInfo.class,
                    one = @One(select = "com.hotelpms.mapper.StaffInfoMapper.queryById")
            )
    })
    UserAccount queryByStaffId(int staffId);
}
