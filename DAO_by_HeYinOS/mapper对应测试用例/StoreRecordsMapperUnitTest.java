package com.hotelpms;

import com.hotelpms.mapper.StoreRecordsMapper;
import com.hotelpms.pojo.StoreRecords;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
public class StoreRecordsMapperUnitTest
{
	@Autowired
	StoreRecordsMapper testMapper;
	//Pass
	//Test for interface 1
	@Test
	public void test1()
	{
		StoreRecords testRecord = new StoreRecords();
		testRecord.setName("AAA");
		testRecord.setAmount(50);
		testRecord.setPrice(new BigDecimal("25.5"));
		testMapper.addStoreRecords(testRecord);
	}
	
	//Pass
	//Test for interface 2
	@Test
	public void test2()
	{
		testMapper.deleteStoreRecords(2);
	}
	
	//Pass
	//Test for interface 3 & 4
	@Test
	public void test34()
	{
		StoreRecords testRecord = testMapper.queryStoreRecordsById(3);
		System.out.println(testRecord);
		testRecord.setName("BBB");
		testMapper.updateStoreRecords(testRecord);
	}
	
	//Pass
	//Test for interface 5
	@Test
	public void test5()
	{
		StoreRecords storeRecords = testMapper.queryStoreRecordsByName("洗衣液");
		System.out.println(storeRecords);
	}
	
	//
	//Test for interface 6
	@Test
	public void test6()
	{
		List<StoreRecords> storeRecordsList = testMapper.queryAllStoreRecords();
		storeRecordsList.forEach(System.out::println);
	}
}