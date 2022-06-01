package com.spring.aop;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;
import org.springframework.core.annotation.AnnotationUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class MyPointCut implements Pointcut {

    @Override
    public ClassFilter getClassFilter() {
        return new MyClassFilter();
    }

    @Override
    public MethodMatcher getMethodMatcher() {
        return new MyMethodMatcher();
    }

    private class MyMethodMatcher implements MethodMatcher {
        @Override
        public boolean matches(Method method, Class<?> targetClass) {
            Annotation[] annoArray = method.getDeclaredAnnotations();
            if (annoArray == null || annoArray.length == 0) {
                return false;
            }

            for (Annotation annotation : annoArray) {
                if (annotation.annotationType() == MyAnnotation.class) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public boolean isRuntime() {
            return false;
        }

        @Override
        public boolean matches(Method method, Class<?> targetClass, Object... args) {
            return false;
        }
    }

    private class MyClassFilter implements ClassFilter {

        @Override
        public boolean matches(Class<?> clazz) {
            return AnnotationUtils.isCandidateClass(clazz, MyAnnotation.class);
        }
    }
}
