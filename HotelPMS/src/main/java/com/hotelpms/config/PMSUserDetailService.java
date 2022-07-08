package com.hotelpms.config;

import com.hotelpms.mapper.UserMapper;
import com.hotelpms.pojo.Role;
import com.hotelpms.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Component
public class PMSUserDetailService implements UserDetailsService {

    private final UserMapper userMapper;

    @Autowired
    public PMSUserDetailService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 查询用户
        User user = userMapper.loadUserByUsername(username);
        // 非空判断
        if (ObjectUtils.isEmpty(user))throw new UsernameNotFoundException("用户名不正确");
        // 查询权限
        List<Role> roles = userMapper.getRoleByUid(user.getId());
        user.setRoles(roles);
    return user;
    }

}
