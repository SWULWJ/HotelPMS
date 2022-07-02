package com.hotelpms.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//账号表
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAccount {
    private int id;
    private String account;
    private String password;
    private StaffInfo staffInfo;
}
