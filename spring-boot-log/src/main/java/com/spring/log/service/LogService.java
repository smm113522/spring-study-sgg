package com.spring.log.service;

import com.spring.log.domain.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.scheduling.annotation.Async;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author hupeng
 * @date 2018-11-24
 */
public interface LogService {

    /**
     * 保存日志数据
     *
     * @param username  用户
     * @param ip        请求IP
     * @param joinPoint /
     * @param log       日志实体
     * @param uid       uid
     */
    @Async
    void save(String username, String ip, ProceedingJoinPoint joinPoint, Log log, Long uid);

}
