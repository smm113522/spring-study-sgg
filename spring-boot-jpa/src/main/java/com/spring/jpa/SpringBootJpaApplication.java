package com.spring.jpa;

import com.alibaba.fastjson.JSON;
import com.spring.jpa.bean.SysUser;
import com.spring.jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.*;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * https://zhuanlan.zhihu.com/p/260421958
 */
@SpringBootApplication
@RestController
public class SpringBootJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJpaApplication.class, args);
    }

    @Autowired
    UserRepository userRepository;

    @GetMapping("/index")
    public String index() {
//        SysUser sysUser = new SysUser();
//        sysUser.setPassword("admin");
//        sysUser.setUsername("admin");
//        sysUser.setCreate_date(new Date());
//        userRepository.save(sysUser);
        List<SysUser> list = userRepository.findAll();
        return JSON.toJSONString(list);
    }

    @GetMapping("/index1")
    public String selectALl() {
        /*id*/
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        /*自定义*/
//        sort = Sort.sort();
        List<SysUser> list1 = userRepository.findAll(sort);
        return JSON.toJSONString(list1);
    }

    @GetMapping("/index2")
    public String select2() {
        /*id*/
        ArrayList<Long> ids = new ArrayList<>();
        ids.add(1l);
        ids.add(2l);
        /*自定义*/
//        sort = Sort.sort();
        List<SysUser> list1 = userRepository.findAllById(ids);
        return JSON.toJSONString(list1);
    }

    @GetMapping("/index3")
    public String select3() {
        /*id*/
        ArrayList<SysUser> ids = new ArrayList<>();
        ids.add(new SysUser("123", "123"));
        ids.add(new SysUser("456", "456"));
        /*自定义*/
//        sort = Sort.sort();
        List<SysUser> list1 = userRepository.saveAll(ids);
        return JSON.toJSONString(list1);
    }

    @GetMapping("/index4/{page}")
    public String select4(@PathVariable("page") int pageSize) {
        Sort sort = Sort.by(Sort.Direction.ASC, "id");
        Pageable pageable = PageRequest.of(pageSize, 1, sort);
        Page<SysUser> all = userRepository.findAll(pageable);
        return JSON.toJSONString(all);
    }

    @GetMapping("/index5")
    public String select5() {
        SysUser sysUser = new SysUser();
        sysUser.setUsername("admin");
        /*like 模糊查询*/
        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example<SysUser> example = Example.of(sysUser, exampleMatcher);
        List<SysUser> all = userRepository.findAll(example);
        return JSON.toJSONString(all);
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    @GetMapping("/index6")
    public String select6() {
        SysUser sysUser = new SysUser();
        sysUser.setUsername("admin");
        /*like 模糊查询*/
        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example<SysUser> example = Example.of(sysUser, exampleMatcher);
        List<SysUser> all = userRepository.findAll(example);
        return JSON.toJSONString(all);
    }

    @GetMapping("/index7")
    public String select7() {
        SysUser sysUser = new SysUser();
        sysUser.setUsername("admin");
        /*like 模糊查询*/
        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example<SysUser> example = Example.of(sysUser, exampleMatcher);
        List<SysUser> all = userRepository.findAll(example);
        long count = userRepository.count();
        return JSON.toJSONString(all);
    }

    /**
     * 多表
     *
     *
     * 事务
     *
     *
     *
     */
}
