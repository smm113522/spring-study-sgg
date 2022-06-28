package com.spring.kisso.controller;

import com.baomidou.kisso.SSOHelper;
import com.baomidou.kisso.enums.TokenOrigin;
import com.baomidou.kisso.security.token.SSOToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * KISSO 演示
 * </p>
 *
 * @author 青苗
 * @since 2017-08-08
 */
@Controller
public class SampleController {

    @Autowired
    protected HttpServletRequest request;

    @Autowired
    protected HttpServletResponse response;

    @ResponseBody
    @RequestMapping("/")
    public String home() {
        return "index";
    }

    @ResponseBody
    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/login.html")
    public String loginHtml() {
        return "login";
    }

    // 授权登录
    @RequestMapping("/login")
    public String login() {
        // 设置登录 COOKIE
        SSOHelper.setCookie(request, response, SSOToken
                        .create()
                        .setIp(request)
                        .setOrigin(TokenOrigin.HTML5)
                        .setId(1000)
                        .setIssuer("kisso"),
                false);
        return redirectTo("index");
    }

    // 查看登录信息
    @ResponseBody
    @RequestMapping("/token")
    public String token() {
        String msg = "暂未登录";
        SSOToken ssoToken = SSOHelper.attrToken(request);
        if (null != ssoToken) {
            msg = "登录信息 ip=" + ssoToken.getIp();
            msg += "， id=" + ssoToken.getId();
            msg += "， issuer=" + ssoToken.getIssuer();
        }
        return msg;
    }

    // 退出登录
    @RequestMapping("/logout")
    public String logout() {
        SSOHelper.clearLogin(request, response);
        return redirectTo("login.html");
    }

    protected String redirectTo(String url) {
        StringBuffer rto = new StringBuffer("redirect:");
        rto.append(url);
        return rto.toString();
    }
}