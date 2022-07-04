package com.hotelpms.controller;

import com.hotelpms.mapper.UserAccountMapper;
import com.hotelpms.pojo.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Test {
    @Autowired
    private UserAccountMapper userAccountMapper;

    @GetMapping("/query")
    public List<UserAccount> queryAllUserAccount() {
        List<UserAccount> list = userAccountMapper.
                queryAllUserAccount();
        return list;
    }

}
