package com.wu;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Attendance02ApplicationTests {

    @Autowired
    DataSource dataSource;
    @Test
    public void contextLoads() throws SQLException {

        System.out.println(dataSource.getClass());
        System.out.println(dataSource.getConnection());

    }

    @Test
    public void ttt(){

        int i = 13;
        System.out.println(i / 3);
        Date date = new Date();
        long time = date.getTime();
        System.out.println(time);
        StringBuilder stringBuilder = new StringBuilder();
        System.out.println(stringBuilder.length());
        stringBuilder.append("123");
        stringBuilder.append("456");
        System.out.println(stringBuilder.length());

    }

}
