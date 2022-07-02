package com.hotelpms;

import com.hotelpms.mapper.RoomTypeMapper;
import com.hotelpms.pojo.RoomType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
public class RoomTypeMapperUnitTest
{
	@Autowired
	RoomTypeMapper roomTypeMapper;
	
	//Pass
	//Test for interface 1
	@Test
	public void test1()
	{
		RoomType testRoomType = new RoomType(45,"AAA",new BigDecimal("12.5"),4,4,"24h");
		roomTypeMapper.addRoomType(testRoomType);
	}
	
	//Pass
	//Test for interface 2
	@Test
	public void test2()
	{
		roomTypeMapper.deleteRoomType(4);
	}
	
	//Pass
	//Test for interface 3 + 4
	@Test
	public void test34()
	{
		RoomType testRoomType = roomTypeMapper.queryRoomTypeById(5);
		System.out.println(testRoomType);
		testRoomType.setName("BBB");
		testRoomType.setMinTime("2h");
		System.out.println(testRoomType);
		roomTypeMapper.updateRoomType(testRoomType);
	}
	
	//Pass
	//Test for interface 5
	@Test
	public void test5()
	{
		RoomType testRoomType = roomTypeMapper.queryRoomTypeByName("监狱");
		System.out.println(testRoomType);
	}
	
	//
	//Test for interface 6
	@Test
	public void test6()
	{
		List<RoomType> testRoomTypeList = roomTypeMapper.queryAllRoomType();
		for(RoomType t: testRoomTypeList)
		{
			System.out.println(t);
		}
	}
}
