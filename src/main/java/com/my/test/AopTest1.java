package com.my.test;


import com.my.aa.TargetSonS2;
import com.my.aop.TargetInterface;
import com.my.aop.son1.TargetSon1;
import com.my.aop.son1.aa.TargetSonS1;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:applicationContext.xml")
public class AopTest1 {
    @Autowired
    private TargetInterface targetInterface;

    @Autowired
    private TargetSon1 targetSon1;

    @Autowired
    private TargetSonS1 targetSonS1;

    @Autowired
    private TargetSonS2 targetSonS2;

    @Test
    public void testAop1(){

//        targetInterface.save();

//        targetSon1.test1();
        targetSonS1.test1();
//        targetSonS2.test1();

    }


}
