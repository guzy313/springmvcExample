package com.my.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

public class MyInterceptor1 implements HandlerInterceptor{

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("interceptor pre..");
        /*
        if(request.getRequestURI().equals("/login/lg")){
            return true;
        }else{
            Object user = request.getSession().getAttribute("user");
            if(user != null){
                return true;
            }else{
                request.getRequestDispatcher(request.getContextPath()+"/jsp/login.jsp").forward(request,response);
                return false;
            }
        }*/

        Object user = request.getSession().getAttribute("user");
        if(user == null ){//登录状态user为空
//            if(!request.getRequestURI().equals("/login/lg")){//如果不是登录请求则拦截
                response.sendRedirect(request.getContextPath()+"/jsp/login.jsp");
                return false;
//            }

        }

        return true;


    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("interceptor post..");

//        if("aa".equals(request.getParameter("name"))){
//
//        }else{
//            request.setAttribute("msg","错误");
//            modelAndView.setViewName("default");
//        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("interceptor after..");
    }
}
