package com.hotelpms.service.Impl;

import com.hotelpms.pojo.StaffInfo;
import com.hotelpms.mapper.StaffInfoMapper;
import com.hotelpms.service.StaffInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffInfoServiceImpl implements StaffInfoService {

    @Autowired
    StaffInfoMapper staffInfoMapper;

    @Override
    public List<StaffInfo> queryAllStaffInfo() {
        return staffInfoMapper.queryAll();
    }

    @Override
    public boolean addStaff(int id,int staffNum,String name,String gender,
                            int age,String position,String tel) {
        StaffInfo staffInfo = staffInfoMapper.queryByStaffNumber(staffNum);
        if(staffInfo == null ){
            staffInfoMapper.addStaffInfo(new StaffInfo(id,staffNum,name, gender,age,position,tel));
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteStaffInfoById(int id) {
        if(staffInfoMapper.queryById(id) != null ){
            staffInfoMapper.deleteStaffInfo(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateStaffInfo(int id,int staffNum,String name,String gender,
                                   int age,String position,String tel) {
            StaffInfo staffInfo = new StaffInfo(id,staffNum,name,
                    gender,age,position,tel);
            staffInfoMapper.updateStaffInfo(staffInfo);
            return true;

//        return false;
    }

    @Override
    public StaffInfo queryStaffInfoById(int id) {
        return staffInfoMapper.queryById(id);
    }

    @Override
    public List<StaffInfo> queryStaffInfoByName(String name) {
        return staffInfoMapper.queryByName(name);
    }



    @Override
    public StaffInfo queryStaffInfoByStaffNumber(int staffNumber){
        return staffInfoMapper.queryByStaffNumber(staffNumber);


    }
}
