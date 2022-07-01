package com.hotelpms.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

//入住登记表
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HousingRecords {
    private int id;
    private int roomId;
    private int tenantId;
    private Date checkInTime;
    private Date checkOutTime;
    private BigDecimal price;
}
