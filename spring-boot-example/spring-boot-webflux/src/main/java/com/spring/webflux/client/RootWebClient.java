package com.spring.webflux.client;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class RootWebClient {

    private final WebClient client = WebClient.create("http://localhost:8078");

    private final Mono<ClientResponse> result = client.get()
            .uri("/user/api/index")
            .accept(MediaType.TEXT_PLAIN).exchange();

    public String res() {
        return result.flatMap(r -> r.bodyToMono(String.class)).block();
    }
}
