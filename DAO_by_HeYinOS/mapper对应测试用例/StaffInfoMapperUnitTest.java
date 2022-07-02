package com.hotelpms;

import com.hotelpms.mapper.StaffInfoMapper;
import com.hotelpms.pojo.StaffInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class StaffInfoMapperUnitTest
{
	@Autowired
	StaffInfoMapper staffInfoMapper;
	
	//Pass
	//Test for interface 1
	@Test
	public void test1()
	{
		StaffInfo staffInfo = new StaffInfo(555,222,"BBB","BBB",55,"BBB","111");
		staffInfoMapper.addStaffInfo(staffInfo);
	}
	
	//Pass
	//Test for interface 2
	@Test
	public void test2()
	{
		staffInfoMapper.deleteStaffInfo(7);
	}
	
	//Pass
	//Test for interface 3
	//[NOTE!] You should use test1() first to add this entry ,so that you can delete it.
	@Test
	public void test3()
	{
		StaffInfo staffInfo = new StaffInfo(555,222,"BBB","BBB",55,"BBB","111");
		staffInfoMapper.updateStaffInfo(staffInfo);
	}
	
	//Pass
	//Test for interface 4
	@Test
	public void test4()
	{
		StaffInfo staffInfo = staffInfoMapper.queryStaffInfoById(1);
		System.out.println(staffInfo);
	}
	
	//Pass
	//Test for interface 5
	@Test
	public void test5()
	{
		List<StaffInfo> staffInfoList = staffInfoMapper.queryStaffInfoByName("包翔天");
		for(StaffInfo i: staffInfoList)
		{
			System.out.println(i);
		}
	}
	
	//Pass
	//Test for interface 6
	@Test
	public void test6()
	{
		List<StaffInfo> staffInfoList = staffInfoMapper.queryAllStaffInfo();
		for(StaffInfo info: staffInfoList)
		{
			System.out.println(info);
		}
	}
	
	//Pass
	//Test for interface 7
	@Test
	public void test7()
	{
		StaffInfo staffInfo = staffInfoMapper.queryStaffInfoByStaffNumber(1);
		System.out.println(staffInfo);
	}
}
