package com.hotelpms.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

//账单表
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillRecord {
    private int id;
    private int billNumber;
    private int staffId;
    private String type;
    private Date time;
    private BigDecimal amount;
    private String details;
    private boolean auditing;
}
