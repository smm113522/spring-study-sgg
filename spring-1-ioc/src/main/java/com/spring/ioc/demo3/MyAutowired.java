package com.spring.ioc.demo3;

import java.lang.annotation.*;

//注解只能加载属性上
@Target(ElementType.FIELD)
//设置运行时有效，需要动态注入
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAutowired {
    String value() default "";
}

//@Target({ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
//@Retention(RetentionPolicy.RUNTIME)
//@Documented
//public @interface Autowired {
//    boolean required() default true;
//}
