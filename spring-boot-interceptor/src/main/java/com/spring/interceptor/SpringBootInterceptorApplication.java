package com.spring.interceptor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBootInterceptorApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootInterceptorApplication.class, args);
    }

    /*拦截*/
    @GetMapping("hello1")
    public String hello1(){
        return "hello1";
    }

    /*不拦截*/
    @GetMapping("hello2")
    public String hello2(){
        return "hello2";
    }


}
