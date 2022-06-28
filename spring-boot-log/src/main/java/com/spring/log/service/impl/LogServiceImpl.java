package com.spring.log.service.impl;

import com.spring.log.domain.Log;
import com.spring.log.service.LogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Method;

/**

 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class LogServiceImpl implements LogService {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(String username, String ip, ProceedingJoinPoint joinPoint,
                     Log log, Long uid) {

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        com.spring.log.log.Log aopLog = method.getAnnotation(com.spring.log.log.Log.class);

        // 方法路径
        String methodName = joinPoint.getTarget().getClass().getName() + "." + signature.getName() + "()";

        StringBuilder params = new StringBuilder("{");
        //参数值
        Object[] argValues = joinPoint.getArgs();
        //参数名称
        String[] argNames = ((MethodSignature) joinPoint.getSignature()).getParameterNames();
        if (argValues != null) {
            for (int i = 0; i < argValues.length; i++) {
                params.append(" ").append(argNames[i]).append(": ").append(argValues[i]);
            }
        }
        // 描述
//        if (log != null) {
//            log.setDescription(aopLog.value());
//        }
        //类型 0-后台 1-前台
        log.setType(aopLog.type());
        if (uid != null) {
            log.setUid(uid);
        }
        assert log != null;
        log.setRequestIp(ip);

        log.setAddress("city");
        log.setMethod(methodName);
        log.setUsername(username);
        log.setParams(params.toString() + " }");
//        this.save(log);
        System.out.println(log.toString());
    }

}
