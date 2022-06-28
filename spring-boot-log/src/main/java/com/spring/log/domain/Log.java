package com.spring.log.domain;


import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author
 * @date
 */
@Data
@NoArgsConstructor
public class Log {

    private Long id;

    /** 操作用户 */
    private String username;

    private String nickname;

    /** 描述 */
    private String description;

    /** 方法名 */
    private String method;

    private Long uid;

    private Integer type;

    /** 参数 */
    private String params;

    /** 日志类型 */
    private String logType;

    /** 请求ip */
    private String requestIp;

    /** 地址 */
    private String address;

    /** 浏览器  */
    private String browser;

    /** 请求耗时 */
    private Long time;

    /** 异常详细  */
    private byte[] exceptionDetail;

    public Log(String logType, Long time) {
        this.logType = logType;
        this.time = time;
    }


}
