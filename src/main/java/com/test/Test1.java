package com.test;

import com.minis.beans.BeansException;
import com.minis.context.ClassPathXmlApplicationContext;
import com.test.Service.AService;

/**
 * @author malin28
 * @date 2024/5/11 15:14
 */
public class Test1 {
    public static void main(String[] args) throws BeansException {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        AService aService = (AService)ctx.getBean("aservice");
        aService.sayHello();
    }
}
