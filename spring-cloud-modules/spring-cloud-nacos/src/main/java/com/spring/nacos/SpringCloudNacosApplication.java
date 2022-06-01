package com.spring.nacos;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.spring.nacos.mapper")
public class SpringCloudNacosApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudNacosApplication.class, args);
    }

}
