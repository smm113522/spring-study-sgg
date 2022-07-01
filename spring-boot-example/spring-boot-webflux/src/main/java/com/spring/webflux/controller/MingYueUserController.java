package com.spring.webflux.controller;

import com.spring.webflux.bean.MingYueUser;
import com.spring.webflux.service.MingYueUserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.stream.IntStream;

/**
 * @author Strive
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class MingYueUserController {

    private static final Logger log = LoggerFactory.getLogger(MingYueUserController.class);

    private final MingYueUserService mingYueUserService;

    @GetMapping("/{userId}")
    public Mono<MingYueUser> queryUserById(@PathVariable Long userId) {
        return Mono.just(mingYueUserService.queryUserById(userId));
    }

    @GetMapping("/api/index")
    public Flux<String> index1() {
        return Flux.just("hello", "hello1");
    }

    @GetMapping("{id}")
    public Mono<String> hello(@PathVariable String id) {
        log.info("spring-webflux 接口(方式1)-注解-start,id:{}", id);
        Mono<String> result = Mono.fromSupplier(() -> "我是服务1");
        log.info("spring-webflux 接口(方式1)-注解-end");
        return result;
    }

    @GetMapping(value = "flux", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> flux() {
        log.info("spring-webflux 接口(方式2)-服务器推送");
        return Flux.fromStream(IntStream.range(1, 5).mapToObj(i -> "我是服务2-" + i));
    }

    @GetMapping("/index")
    public Mono<String> index() {
        Mono<String> result = Mono.fromSupplier(() -> mingYueUserService.selectResult());
        return result;
    }

}
