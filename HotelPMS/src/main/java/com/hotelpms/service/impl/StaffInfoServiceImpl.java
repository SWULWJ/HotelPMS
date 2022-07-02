package com.hotelpms.service.impl;

import com.hotelpms.pojo.StaffInfo;
import com.hotelpms.mapper.StaffInfoMapper;
import com.hotelpms.service.StaffInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffInfoServiceImpl implements StaffInfoService {

    @Autowired
    private StaffInfoMapper staffInfoMapper;

    @Override
    public boolean addStaff(int id, int staffNum, String name,
                            String gender, int age, String position,
                            String tel) {
        if(staffInfoMapper.queryStaffInfoById(id) == null ) {
            StaffInfo staffInfo = new StaffInfo(id, staffNum, name,
                    gender, age, position, tel);
            staffInfoMapper.addStaffInfo(staffInfo);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteStaffInfoById(int id) {
        if(staffInfoMapper.queryStaffInfoById(id) != null) {
            staffInfoMapper.deleteStaffInfo(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateStaffInfo(int id, int staffNum, String name,
                                   String gender, int age, String position,
                                   String tel) {
        if(staffInfoMapper.queryStaffInfoById(id) != null ) {
            StaffInfo staffInfo = new StaffInfo(id, staffNum, name, gender,
                    age, position,tel);
            staffInfoMapper.addStaffInfo(staffInfo);
            return true;
        }
        return false;
    }

    @Override
    public StaffInfo queryStaffInfoById(int id) {
        return staffInfoMapper.queryStaffInfoById(id);
    }

    @Override
    public List<StaffInfo> queryStaffInfoByName(String name) {
        return staffInfoMapper.queryStaffInfoByName(name);
    }

    @Override
    public List<StaffInfo> queryAllStaffInfo() {
        return staffInfoMapper.queryAllStaffInfo();
    }
}
