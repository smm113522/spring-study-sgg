package com.spring.aop;

import org.springframework.stereotype.Component;

@Component
public class TestService {

    @MyAnnotation
    public void test() {
        System.out.println("test!");
    }
}
