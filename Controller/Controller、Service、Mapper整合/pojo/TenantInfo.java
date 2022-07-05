package com.hotelpms.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

//房客信息表
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TenantInfo {
    private int id;
    private String name;
    private String gender;
    private String idCard;
}
