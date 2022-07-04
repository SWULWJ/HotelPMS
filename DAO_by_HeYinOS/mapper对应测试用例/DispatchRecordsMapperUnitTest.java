package com.hotelpms;

import com.hotelpms.mapper.DispatchRecordsMapper;
import com.hotelpms.pojo.DispatchRecords;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class DispatchRecordsMapperUnitTest
{
	@Autowired
	DispatchRecordsMapper testMapper;
	
	//Pass
	//Test for interface 1
	@Test
	public void test1()
	{
		DispatchRecords dispatchRecords = testMapper.queryAllById(1);
		System.out.println(dispatchRecords);
	}
	
	//Pass
	//Test for interface 2
	@Test
	public void test2()
	{
		List<DispatchRecords> dispatchRecordsList = testMapper.queryAllByStaffNumber(1);
		dispatchRecordsList.forEach(System.out::println);
	}
}
