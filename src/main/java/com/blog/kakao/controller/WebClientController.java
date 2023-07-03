package com.blog.kakao.controller;

import com.blog.kakao.config.WebClientConfig;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
public class WebClientController {

    @GetMapping("test")
    public Mono<String> bodyToMonoTest() {
        // WebClient.create() -> 빠르게 테스트할때 사용
        // bodyToMono : 1개의 값 리턴 / bodyToFlux : 복수의 값 리턴
        WebClient client = WebClient.create();
        return client.get()
                .uri("http://localhost")
                .retrieve()
                .bodyToMono(String.class);
    }

//    @GetMapping("test2")
//    public Mono<String> filterTest() {
//        WebClient client = WebClientConfig.createWebClient();
//    }
}
