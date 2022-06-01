package com.spring.aop.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopConfig {

    @Pointcut("execution(* com.spring.aop.*.*(..))")
    public void pointCut() {
    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoin) {
        System.out.println("go go go MyAspectJ process!!!");
        Object obj = null;
        try {
            obj = joinPoin.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        return obj;
    }
}

