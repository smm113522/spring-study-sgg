package com.spring.shiro;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBootShiroApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootShiroApplication.class, args);
    }

    @GetMapping("/hello")
    public String hello() {
        String userName = "admin123";
        String password = "111111";
        String salt = "dfaa90";
        String s = encryptPassword(userName, password, salt);
        return s;
    }

    public String encryptPassword(String username, String password, String salt) {
        return new Md5Hash(username + password + salt).toHex();
    }

}


