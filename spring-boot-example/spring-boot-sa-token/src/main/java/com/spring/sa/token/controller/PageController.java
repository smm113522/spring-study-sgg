package com.spring.sa.token.controller;

import cn.dev33.satoken.annotation.*;
import cn.dev33.satoken.basic.SaBasicUtil;
import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PageController {

    @RequestMapping("/login")
    public SaResult login(String account, String pw) {
        if (!StringUtils.isEmpty(account) && !StringUtils.isEmpty(pw)) {
            StpUtil.login(account, "PC");
            StpUtil.getSession().set("user", account);
            SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
            return SaResult.data(tokenInfo);
        }
        return SaResult.error();
    }

    /**
     * http://sa:123456@localhost:8081/info
     * 这样才可以访问
     *
     * @return 结果
     */
    @SaCheckLogin
    @GetMapping("/info")
    @SaCheckRole("super-admin")
    @SaCheckPermission("user-info")
    @SaCheckSafe()
    @SaCheckBasic(account = "sa:123456")
    public SaResult info() {
        String user = (String) StpUtil.getSession().get("user");
        return SaResult.data(user);
    }

    @SaCheckLogin
    @GetMapping("/safe")
    @SaCheckRole("super-admin")
    @SaCheckPermission("user-info")
    public SaResult safe() {
        StpUtil.openSafe(120);
        return SaResult.data(null);
    }

}
