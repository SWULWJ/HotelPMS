package com.hotelpms.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

//房源信息表
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomInfo {
    private int id;
    private int roomNumber;
    private RoomType roomType;
    private String state;
    private String building;
    private String floor;
}
