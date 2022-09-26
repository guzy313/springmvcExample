package com.my.test;


import com.my.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringTest1 {
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Test
    public void update(){
        int count = jdbcTemplate.update("update test27 set name = ? where id = ?", "测试", 1);
        System.out.println(count);

    }


    public void query1(){
        List<User> query = jdbcTemplate.query("", new BeanPropertyRowMapper<>(User.class));
    }


    @Test
    public void insert(){
        jdbcTemplate.execute("insert into  user values (1,'钟离','123')");

    }

}
