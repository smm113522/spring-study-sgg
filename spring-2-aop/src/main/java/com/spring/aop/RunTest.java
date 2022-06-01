package com.spring.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class RunTest {

    @Autowired
    private TestService testService;

    @PostConstruct
    public void test() {
        testService.test();
    }
}
