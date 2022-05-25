package com.spring.thread.app.controller;

import com.spring.thread.app.service.DemoService;
import com.spring.thread.app.service.ThreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    ThreadService demoService;

    @GetMapping("/thread")
    public String demo() {
        String s = demoService.threadActive();
        return s;
    }

}
