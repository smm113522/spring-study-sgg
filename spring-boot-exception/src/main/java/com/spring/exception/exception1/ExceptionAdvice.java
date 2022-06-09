package com.spring.exception.exception1;

import com.alibaba.fastjson.JSON;
import com.spring.exception.utils.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//声明处理带有@Controller注解的类出现的异常
//@ControllerAdvice(annotations = Controller.class)
/*所有*/
@ControllerAdvice()
public class ExceptionAdvice {

    public static final Logger logger = LoggerFactory.getLogger(ExceptionAdvice.class);

    @ExceptionHandler({Exception.class})
    public void handleException(Exception e, HttpServletRequest request, HttpServletResponse response) throws IOException {
        logger.error("服务器发生异常：" + e.getMessage());
        JsonUtils.writheJson(response, JSON.toJSONString(new ResponseEntity<>("服务器异常2！" + e.getMessage(), HttpStatus.BAD_GATEWAY)));
    }



    /**
     * 业务错误
     *
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = ErrorRequestException.class)
    @ResponseBody
    public ResponseEntity bizExceptionHandler(HttpServletRequest req, ErrorRequestException e) {
        logger.error("发生业务异常！原因是：{}", e.getMessage());
        return new ResponseEntity<>("服务器异常3！" + e.getMessage(), HttpStatus.BAD_GATEWAY);
    }

}
