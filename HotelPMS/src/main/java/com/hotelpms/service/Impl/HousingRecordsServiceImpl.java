package com.hotelpms.service.Impl;

import com.hotelpms.pojo.HousingRecords;
import com.hotelpms.service.HousingRecordsService;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class HousingRecordsServiceImpl implements HousingRecordsService {
    @Override
    public boolean addHosingRecord(int id, int room_id, int tenant_id, Date check_in_time, Date check_out_time, BigDecimal price) {
        return false;
    }

    @Override
    public boolean deleteHousingRecordById(int id) {
        return false;
    }

    @Override
    public boolean updateHousingRecord(int id, int room_id, int tenant_id, Date check_in_time, Date check_out_time, BigDecimal price) {
        return false;
    }

    @Override
    public HousingRecords queryHousingRecordById(int id) {
        return null;
    }

    @Override
    public List<HousingRecords> queryHousingRecordByTime(Date check_in, Date check_out) {
        return null;
    }

    @Override
    public List<HousingRecords> queryHousingRecordByRoom(int room_id) {
        return null;
    }

    @Override
    public List<HousingRecords> queryHousingRecordByTenant(int tenant_id) {
        return null;
    }

    @Override
    public List<HousingRecords> queryAllHousingRecord() {
        return null;
    }
}
