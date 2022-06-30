package com.hotelpms.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//员工信息表
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StaffInfo {
    private int id;
    private int staffNumber;
    private String name;
    private String gender;
    private int age;
    private int position;
    private String tel;
}
