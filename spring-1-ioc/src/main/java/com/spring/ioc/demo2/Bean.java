package com.spring.ioc.demo2;

/**
 * Spring中万物皆是Bean，用于存放对象
 * 管理Bean也是管理对象
 * */
public class Bean {
    //Bean的名字Id
    private String name;
    //Bean(java中的对象)对应的路径“包名.类名”
    private String path;

    /**
     * 生成get，set方法给对象赋值
     * */
    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPath(String path) {
        this.path = path;
    }
}