package com.my.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspect {

    public void before(){
        System.out.println("before..");
    }


    public void after(){
        System.out.println("after..");
    }

    public void around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕前");
        pjp.proceed();
        System.out.println("环绕后");

    }


    public void exception(){
        System.out.println("exception...");
    }

}
