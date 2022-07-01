package com.hotelpms;

import com.hotelpms.mapper.StaffInfoMapper;
import com.hotelpms.mapper.UserAccountMapper;
import com.hotelpms.pojo.StaffInfo;
import com.hotelpms.pojo.UserAccount;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class UserAccountMapperUnitTest
{
	@Autowired
	UserAccountMapper userAccountMapper;
	
	@Autowired
	StaffInfoMapper staffInfoMapper;
	
	//Pass
	//Test for interface 1
	//[ NOTE! ] I use interface from StaffInfoMapper to get StaffInfo instance.
	@Test
	public void test1()
	{
		//Step 1: get the staffInfo
		StaffInfo testStaff = staffInfoMapper.queryStaffInfoById(1);
		System.out.println(testStaff);
		//Step 2: set StaffInfo for UserAccount
		UserAccount testUser = new UserAccount();
		testUser.setStaffInfo(testStaff);
		testUser.setAccount("AAAAAA");
		testUser.setPassword("AAAAAA");
		System.out.println(testUser);
		//Step 3: use the interface 3 of UserAccountMapper
		userAccountMapper.addUserAccount(testUser);
	}
	
	//Pass
	//Test for interface 2
	@Test
	public void test2()
	{
		userAccountMapper.deleteUserAccountById(5);
	}
	
	//All Pass
	//Test for interface 3 & 4
	@Test
	public void test3()
	{
		//Step 1: get UserAccount
		UserAccount testUser = userAccountMapper.queryUserAccountById(6);
		//Step 2: modify UserAccount
		testUser.setAccount("BBBBBB");
		testUser.setPassword("BBBBBB");
		//Step 3: commit to database
		userAccountMapper.updateUserAccount(testUser);
	}
	
	//Pass
	//Test for interface 5
	@Test
	public void test5()
	{
		List<UserAccount> userAccountList = userAccountMapper.queryAllUserAccount();
		for(UserAccount u: userAccountList)
		{
			System.out.println(u);
		}
	}
	
	//Pass
	//Test for interface 6
	@Test
	public void test6()
	{
		UserAccount testUser = userAccountMapper.queryUserAccountByAccount("admin");
		System.out.println(testUser);
	}
}
