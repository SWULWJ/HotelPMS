package com.hotelpms.mapper;

import com.hotelpms.pojo.Role;
import com.hotelpms.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    // 根据用户名返回用户
    @Select("SELECT * FROM user WHERE username=#{username}")
    User loadUserByUsername(String username);

    // 根据用户Id查询角色
    @Select("SELECT r.id, r.name "
            +"FROM role r, user_role ur "
            +"WHERE r.id = ur.rid "
            +"AND ur.uid = #{uid}")
    List<Role> getRoleByUid(int uid);

}
