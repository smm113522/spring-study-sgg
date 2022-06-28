package com.spring.kisso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootKissoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootKissoApplication.class, args);
    }

//    http://localhost:8088/login.html
//    http://localhost:8088/login//登录
//    http://localhost:8088/logout//退出 之后进入登录界面
//    http://localhost:8088/   //如果登录了显示首页，如果没有登录进入登录界面
//    http://localhost:8088/token   //如果登录了显示信息，如果没有登录进入登录界面

}
