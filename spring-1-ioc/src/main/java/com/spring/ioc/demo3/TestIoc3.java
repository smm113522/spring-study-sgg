package com.spring.ioc.demo3;

import org.springframework.beans.factory.annotation.Autowired;

public class TestIoc3 {

    @MyAutowired
    Teacher teacher;

    @Autowired
    Teacher teacher1;

    public static void main(String[] args) {
        System.out.println();
    }

}
