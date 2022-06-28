package com.spring.log.exception;

import com.spring.log.log.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionController {

    @Log
    @GetMapping("/index")
    public String index() {
        int i = 1 / 0;
        return "index";
    }

    @Log
    @GetMapping("/index1")
    public String index1() throws ErrorRequestException {
        int i = 1 / 0;
        return "index1";
    }

    @Log
    @GetMapping("/index2")
    public String index2() {
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "index2";
    }

    @Log
    @GetMapping("/index3")
    public String index3() {
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            throw new ErrorRequestException(e.getMessage());
        }
        return "index2";
    }

    @Log
    @GetMapping("/index4")
    public String index4() {
        try {
            System.out.println("hello");
        } catch (Exception e) {
            throw new ErrorRequestException(e.getMessage());
        }
        return "index4";
    }

}
