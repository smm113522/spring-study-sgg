package com.spring.sa.token.listener;

import cn.dev33.satoken.listener.SaTokenListener;
import cn.dev33.satoken.stp.SaLoginModel;
import org.springframework.stereotype.Component;

/**
 * 自定义侦听器的实现
 */
@Component
public class TokenListener implements SaTokenListener {

    /**
     * 每次登录时触发
     */
    @Override
    public void doLogin(String s, Object o, String s1, SaLoginModel saLoginModel) {
        System.out.println("登录成功");
    }

    /**
     * 每次注销时触发
     */
    @Override
    public void doLogout(String loginType, Object loginId, String tokenValue) {
        // ...
    }

    /**
     * 每次被踢下线时触发
     */
    @Override
    public void doKickout(String loginType, Object loginId, String tokenValue) {
        // ...
        System.out.println("您被踢下线了");
    }

    /**
     * 每次被顶下线时触发
     */
    @Override
    public void doReplaced(String loginType, Object loginId, String tokenValue) {
        // ...
        System.out.println("您被顶下线了");
        //通过mq通知前端用户被顶下线
//        rabbitTemplate.convertAndSend(tokenValue,"10000");
    }

    /**
     * 每次被封禁时触发
     */
    @Override
    public void doDisable(String loginType, Object loginId, long disableTime) {
        // ...
    }

    /**
     * 每次被解封时触发
     */
    @Override
    public void doUntieDisable(String loginType, Object loginId) {
        // ...
    }

    /**
     * 每次创建Session时触发
     */
    @Override
    public void doCreateSession(String id) {
        // ...
    }

    /**
     * 每次注销Session时触发
     */
    @Override
    public void doLogoutSession(String id) {
        // ...
    }

}


