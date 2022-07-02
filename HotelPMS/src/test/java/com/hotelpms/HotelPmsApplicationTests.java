package com.hotelpms;

import com.hotelpms.mapper.UserAccountMapper;
import com.hotelpms.pojo.StaffInfo;
import com.hotelpms.pojo.UserAccount;
import com.hotelpms.service.StaffInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

@SpringBootTest
class HotelPmsApplicationTests {

    @Autowired
    private StaffInfoService staffInfoService;

    @Autowired
    DataSource dataSource;

    @Autowired
    UserAccountMapper userAccountMapper;

    @Test
    void list(){
        List<StaffInfo> list = staffInfoService.queryAllStaffInfo();
        list.forEach(System.out::println);
    }

    @Test
    void contextLoads() throws SQLException {




        System.out.println(dataSource.getClass());
        System.out.println(dataSource.getConnection());

        List<UserAccount> list = userAccountMapper.queryAllUserAccount();
        System.out.println(list);
    }

}
