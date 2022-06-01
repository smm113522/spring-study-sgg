package com.spring.ioc.demo2;

import com.spring.ioc.demo3.MyAutowired;
import com.spring.ioc.demo3.Teacher;

public class TestIoc2 {

    public static void main(String[] args) throws Exception {
        SpringContext spring = new SpringContext();
        Hello o = (Hello) spring.getBean("Hello");
        System.out.println(o);
        o.hi();
    }

}
