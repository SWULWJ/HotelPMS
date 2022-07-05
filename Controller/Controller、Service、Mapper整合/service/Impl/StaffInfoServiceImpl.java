package com.hotelpms.service.Impl;

import com.hotelpms.mapper.UserAccountMapper;
import com.hotelpms.pojo.StaffInfo;
import com.hotelpms.mapper.StaffInfoMapper;
import com.hotelpms.pojo.UserAccount;
import com.hotelpms.service.StaffInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


//通过后端集成测试
@Service
public class StaffInfoServiceImpl implements StaffInfoService {

    @Autowired
    StaffInfoMapper staffInfoMapper;
    @Autowired
    UserAccountMapper userAccountMapper;

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
//        BillRecord,DispatchRecord中都包含staff_id
//        首先根据外键查询UserAccount表中的该用户信息,进行删除
        UserAccount userAccount = userAccountMapper.queryByStaffId(id);
        if(userAccount != null ){
            userAccountMapper.deleteUserAccount(userAccount.getId());
//        删除StaffInfo中的职员信息
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
