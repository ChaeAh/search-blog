package kakao.controller;

import kakao.model.BlogRequest;
import kakao.model.BlogResponse;
import kakao.model.HttpHeaders;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
@RequiredArgsConstructor
public class WebClientController {

    private final WebClient webClient;

    @GetMapping("/search")
    public BlogResponse commonBlogSearch(@RequestBody BlogRequest request) {
        log.info("bodyToMono TEST START");
        // WebClient.create() -> 빠르게 테스트할때 사용
        // bodyToMono : 1개의 값 리턴 / bodyToFlux : 복수의 값 리턴
        // Mono : Webflux 대표적 return 타입 파라미터를 한번에 전달하고, 한번에 받아온다.
        Mono<BlogResponse> blogResponseMono = webClient.get()
                .uri(String.format("https://dapi.kakao.com/v2/search/blog?query=%s", request.getQuery()))
                .header(HttpHeaders.AUTHORIZATION, "KakaoAK 6958d15352ec2841aebdf071727bd632")
                .retrieve() // response개체의 body를 받아 디코딩
                .bodyToMono(BlogResponse.class)
                .onErrorResume(throwable -> {
                    return Mono.error(new RuntimeException(throwable));
                });
        BlogResponse blogResponse = blogResponseMono.block();
        return blogResponse;
    }

}
