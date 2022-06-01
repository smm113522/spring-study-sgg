package com.spring.druid.dynamic;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.spring.druid.dynamic.mapper")
public class SpringBootDruidDynamicApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDruidDynamicApplication.class, args);
    }

}
