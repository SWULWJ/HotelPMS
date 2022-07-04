package com.hotelpms.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

//库存信息表
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StoreRecords {
    private int id;
    private String name;
    private int amount;
    private BigDecimal price;
}
