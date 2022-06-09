package com.spring.log;

import com.spring.log.log.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 *
 *
 *
 *
 *
 *
 *
 *
 * https://gitee.com/lixiaogou/springbootdemo/tree/master/springbootEncrypt
 * 接口加密处理
 *
 *
 *
 *  https://gitee.com/springboot-hlh/spring-boot-csdn/tree/master/09-spring-boot-interface-crypto
 *
 *
 */

@SpringBootApplication
@RestController
public class SpringBootLogApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootLogApplication.class, args);
    }

    /*LogServiceImpl*/
    /*info 日志写入进去了*/
    @Log
    @GetMapping("/hello")
    public String hello() {
        System.out.println("hello");
        return "hello";
    }

    /*错误也会写进去了。*/
    @Log
    @GetMapping("/error1")
    public String error1() {
        try {
            int i = 1 / 0;
            System.out.println(i);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "hello";
    }

    @Log
    @GetMapping("/error2")
    public String error2() {
        int i = 1 / 0;
        System.out.println(i);
        return "hello";
    }

    @Log
    @GetMapping("/error3")
    public String error3() throws Exception{
        int i = 1 / 0;
        System.out.println(i);
        return "hello";
    }

}
