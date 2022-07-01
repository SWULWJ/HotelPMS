package com.hotelpms.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

//房间信息表
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomType {
    private int id;
    private String name;
    private BigDecimal price;
    private int bedNumber;
    private int maxPeople;
    private String minTime;
}
