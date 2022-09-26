package com.my.test;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.my.dao.OrdersMapper;
import com.my.dao.UserMapper;
import com.my.domain.Orders;
import com.my.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import javax.jws.soap.SOAPBinding;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MybatisTest1 {


    @Test
    public void test1() throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("mybatisConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession();
        List<User> l = sqlSession.selectList("UserMapper.select1", "钟离");
        System.out.println(l);
        sqlSession.close();

    }

    @Test
    public void test2() throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("mybatisConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession();

        List<String> conditions = new ArrayList<>();
        conditions.add("钟离");
        conditions.add("绫华");

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.findByConditions(conditions);
        System.out.println(users);
        sqlSession.close();

    }


    @Test
    public void test3() throws IOException {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = sqlSessionFactoryBuilder.build(Resources.getResourceAsStream("mybatisConfig.xml"));
        SqlSession sqlSession = build.openSession();
        OrdersMapper mapper = sqlSession.getMapper(OrdersMapper.class);
        List<Orders> all = mapper.findAll();
        System.out.println(all);


    }


    @Test
    public void test4() throws IOException {
        InputStream ris = Resources.getResourceAsStream("mybatisConfig.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = sqlSessionFactoryBuilder.build(ris);
        SqlSession sqlSession = build.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);


//        PageHelper.startPage(1,1);
        List<User> userOrders = mapper.findUserOrders();

        System.out.println(userOrders);
        sqlSession.close();


    }

}
