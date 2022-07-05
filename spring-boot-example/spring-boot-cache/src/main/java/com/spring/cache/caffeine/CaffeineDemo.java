package com.spring.cache.caffeine;


import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class CaffeineDemo {

    Cache<String, String> cache;

    @GetMapping("/index")
    public String index() {
        cache = Caffeine.newBuilder()
                //5秒没有读写自动删除
                .expireAfterAccess(5, TimeUnit.SECONDS)
                //最大容量1024个，超过会自动清理空间
                .maximumSize(1024)
                .removalListener(((key, value, cause) -> {
                    //清理通知 key,value ==> 键值对   cause ==> 清理原因
                    System.out.println(key);
                    System.out.println(value);
                    System.out.println(cause);

                    /*
                    *   张三
                        浙江
                        EXPIRED
                    * */

                }))
                .build();
        cache.put("张三", "浙江");
        return "添加成功";
    }

    @GetMapping("/index1")
    public String index1() {
        if (cache == null) {
            cache = Caffeine.newBuilder()
                    //5秒没有读写自动删除
                    .expireAfterAccess(5, TimeUnit.SECONDS)
                    //最大容量1024个，超过会自动清理空间
                    .maximumSize(1024)
                    .removalListener(((key, value, cause) -> {
                        //清理通知 key,value ==> 键值对   cause ==> 清理原因
                        System.out.println(key);
                        System.out.println(value);
                        System.out.println(cause);
                    }))
                    .build();
        }

        String 张三 = cache.getIfPresent("张三");
        return 张三;
    }

}
