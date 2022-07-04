package com.hotelpms.service.finish;

import com.hotelpms.mapper.DispatchRecordsMapper;
import com.hotelpms.pojo.DispatchRecords;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DispatchRecordServiceImpl implements DispatchRecordService{
    

    @Autowired
    DispatchRecordsMapper dispatchRecordsMapper;
    
    @Override
    public List<DispatchRecords> queryAll(){
        return dispatchRecordsMapper.queryAll();
    }
    
    @Override
    public DispatchRecords queryAllById(int id) {
        return dispatchRecordsMapper.queryById(id);
    }

   
    @Override
    public List<DispatchRecords> queryAllByStaffNumber( int staffNumber) {
        return dispatchRecordsMapper.queryByStaffNumber(staffNumber);
    }

   
}
