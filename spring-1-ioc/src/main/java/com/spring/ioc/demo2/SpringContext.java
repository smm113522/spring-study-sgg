package com.spring.ioc.demo2;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 模拟spring框架
 * 创建Bean
 * 存放Bean
 * 设置取出Bean的方法，有Bean就直接取出没有需要创建一个
 */
public class SpringContext {
    //创建一个容器存放Bean
    private List<Bean> beanFactory = new ArrayList<>();

    //构造方法创建框架是自动执行
    public SpringContext() throws Exception {
        //创建一个Bean
        Bean bean = new Bean();

        bean.setName("Hello");
        bean.setPath("com.spring.ioc.demo2.Hello");
        //将Bean加入容器
        beanFactory.add(bean);
        init();
    }

    /**
     * 创建容器Key是类名Value是路径
     * 通过Class.forName(path).newInstance()获取对象
     */
    private final Map<String, Object> factoryBeanObject =
            new ConcurrentHashMap<>();

    public void init() throws Exception {
        for (Bean b : beanFactory) {
            String key = b.getName();
            //反射创建对象,作为value存入map
            String path = b.getPath();
            Object value = Class.forName(path).newInstance();
            factoryBeanObject.put(key, value);
        }
    }

    //3,getBean()有就直接取出来,没有就创建并放入容器
    public Object getBean(String name) {
        return factoryBeanObject.get(name);
    }
}