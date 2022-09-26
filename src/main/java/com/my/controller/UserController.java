package com.my.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @ResponseBody
    @RequestMapping("test1")
    public void test1(){
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from users");
        System.out.println(list);
    }

    @RequestMapping("tpg1")
    public String testpg1(){
        return "redirect:/jsp/testPage1.jsp";
    }

    @ResponseBody
    @RequestMapping(value = "testS")
    public void testLoginSuccess1(HttpServletRequest request,Map<String,Object> model){


            model.put("aa","ddd");


    }

}
