package com.spring.exception.exception1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionController {

    @GetMapping("/index")
    public String index() {
        int i = 1 / 0;
        return "index";
    }

    @GetMapping("/index1")
    public String index1() throws ErrorRequestException {
        int i = 1 / 0;
        return "index1";
    }

    /**
     * 不可全
     *
     * @return
     */
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

    @GetMapping("/index3")
    public String index3() {
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            throw new ErrorRequestException(e.getMessage());
        }
        return "index2";
    }

}
