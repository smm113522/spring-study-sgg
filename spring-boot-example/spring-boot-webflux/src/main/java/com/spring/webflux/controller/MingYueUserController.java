package com.spring.webflux.controller;

import com.spring.webflux.bean.MingYueUser;
import com.spring.webflux.service.MingYueUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/** @author Strive */
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class MingYueUserController {

    private final MingYueUserService mingYueUserService;

    @GetMapping("/{userId}")
    public Mono<MingYueUser> queryUserById(@PathVariable Long userId) {
        return Mono.just(mingYueUserService.queryUserById(userId));
    }
}
