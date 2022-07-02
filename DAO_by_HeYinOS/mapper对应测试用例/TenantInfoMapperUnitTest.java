package com.hotelpms;

import com.hotelpms.mapper.TenantInfoMapper;
import com.hotelpms.pojo.TenantInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TenantInfoMapperUnitTest
{
	@Autowired
	TenantInfoMapper testMapper;
	
	//Pass
	//Test for interface 1
	@Test
	public void test1()
	{
		TenantInfo testInfo = new TenantInfo();
		testInfo.setName("AAA");
		testInfo.setGender("AAA");
		testInfo.setIdCard("AAA");
		System.out.println(testInfo);
		testMapper.addTenantInfo(testInfo);
	}
	
	//Pass
	//Test for interface 2
	@Test
	public void test2()
	{
		testMapper.deleteTenantInfo(3);
	}
	
	//
	//Test for interface 3 & 4
	@Test
	public void test3()
	{
		TenantInfo testInfo = testMapper.queryTenantInfoById(4);
		System.out.println(testInfo);
		testInfo.setName("BBB");
		testInfo.setGender("BBB");
		testInfo.setIdCard("BBB");
		System.out.println(testInfo);
		testMapper.updateTenantInfo(testInfo);
	}
	
	//Pass
	//Test for interface 5
	@Test
	public void test4()
	{
		List<TenantInfo> tenantInfoList = testMapper.queryTenantInfoByName("刘书源");
		tenantInfoList.forEach(System.out::println);
	}
	
	//Pass
	//Test for interface 6
	@Test
	public void test5()
	{
		List<TenantInfo> tenantInfoList = testMapper.queryAllTenantInfo();
		tenantInfoList.forEach(System.out::println);
	}
}
