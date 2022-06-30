package com.hotelpms;

import com.hotelpms.mapper.UserAccountMapper;
import com.hotelpms.pojo.UserAccount;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

@SpringBootTest
class HotelPmsApplicationTests {

    @Autowired
    DataSource dataSource;

    @Autowired
    UserAccountMapper userAccountMapper;


    @Test
    void contextLoads() throws SQLException {


        System.out.println(dataSource.getClass());
        System.out.println(dataSource.getConnection());

        List<UserAccount> list = userAccountMapper.queryAllUserAccount();
        System.out.println(list);
    }

}
