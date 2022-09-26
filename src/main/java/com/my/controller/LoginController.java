package com.my.controller;


import com.my.domain.User;
import com.mysql.cj.Session;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @ResponseBody
    @RequestMapping("lg")
    public void lg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String pwd = request.getParameter("pwd");

        List<User> users = jdbcTemplate.query("select * from user", new BeanPropertyRowMapper<>(User.class));
        for (User u:users) {
            if(u.getName().equals(username)){
                if(u.getPwd().equals(pwd)){
                    request.getSession().setAttribute("user",username);
                    System.out.println("登录成功");
                    response.sendRedirect(request.getContextPath()+"/index.jsp");
                    return;
                }
            }
        }
        request.setAttribute("loginMsg","登录失败");
        request.getRequestDispatcher(request.getContextPath()+"/jsp/login.jsp").forward(request,response);

    }


}
