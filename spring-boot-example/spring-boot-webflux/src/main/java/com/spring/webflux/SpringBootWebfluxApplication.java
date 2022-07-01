package com.spring.webflux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBootWebfluxApplication {

//    private static final Logger log = LoggerFactory.getLogger(MingYueUserController.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebfluxApplication.class, args);
//        String res = new RootWebClient().res();
//        log.info("send--->,{}", res);
    }

}
