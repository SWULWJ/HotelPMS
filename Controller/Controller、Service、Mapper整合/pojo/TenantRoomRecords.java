package com.hotelpms.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

//房间住户全信息表
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TenantRoomRecords
{
	private int id;
	private TenantInfo tenantInfo;
	private RoomInfo roomInfo;
	private Date inTime;
	private Date outTime;
	private boolean active;
	private boolean booker;
	private BigDecimal price;
}
