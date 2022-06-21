package com.spring.knife4j;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test")
@Api(tags = "测试swagger")
public class Knife4jTestController {

    @GetMapping(value = "/hello")
    @ApiImplicitParam(name = "name", value = "姓名", required = true)
    @ApiOperation("测试接口")
    public String test(@RequestParam("name") String name) {
        return "hello " + name + ", I am  meimei han";
    }

}
