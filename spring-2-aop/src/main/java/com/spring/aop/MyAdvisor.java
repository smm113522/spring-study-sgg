package com.spring.aop;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.PointcutAdvisor;
import org.springframework.stereotype.Component;

@Component
public class MyAdvisor implements PointcutAdvisor {

    @Override
    public Advice getAdvice() {
        return new MyInterceptAdvice();
    }

    @Override
    public boolean isPerInstance() {
        return false;
    }

    @Override
    public Pointcut getPointcut() {
        return new MyPointCut();
    }
}
