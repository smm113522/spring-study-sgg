package com.spring.xxljob;

import com.xxl.job.core.biz.model.ReturnT;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@SpringBootApplication
@RestController
public class XxlJobApplication {

    public static void main(String[] args) {
        SpringApplication.run(XxlJobApplication.class, args);
    }

    @GetMapping("/")
    public ReturnT<String> index(){
        return ReturnT.SUCCESS;
    }

}
