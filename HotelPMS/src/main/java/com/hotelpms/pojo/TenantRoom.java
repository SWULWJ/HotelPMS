package com.hotelpms.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//房客客房表
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TenantRoom {
    private int id;
    private int tenantId;
    private int roomId;
}
