package com.hotelpms.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

//派遣表
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DispatchRecords {
    private int id;
    private StaffInfo staffInfo;
    private String location;
    private Date startTime;
    private Date endTime;
    private String type;
    private String details;
}
