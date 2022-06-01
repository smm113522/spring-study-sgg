package com.spring.druid;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.spring.druid.mapper")
public class SpringBootDruidApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDruidApplication.class, args);
    }

}
