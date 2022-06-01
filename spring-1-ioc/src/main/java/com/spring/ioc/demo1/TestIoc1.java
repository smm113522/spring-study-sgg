package com.spring.ioc.demo1;

import com.spring.ioc.demo3.MyAutowired;
import com.spring.ioc.demo3.Teacher;

public class TestIoc1 {


    public static void main(String[] args) {
        XmlApplicationContext context = new XmlApplicationContext("bean.xml");
        Car car = (Car) context.getBean("car");
        System.out.println(car);
    }

}
