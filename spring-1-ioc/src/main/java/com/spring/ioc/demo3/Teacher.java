package com.spring.ioc.demo3;

import org.springframework.stereotype.Component;

@Component
public class Teacher {
    private String name = "韩梅梅";

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                '}';
    }

}