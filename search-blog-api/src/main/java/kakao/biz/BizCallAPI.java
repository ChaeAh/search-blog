package kakao.biz;

import kakao.model.ApiRequest;
import kakao.model.HttpHeaders;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class BizCallAPI {

    private final WebClient client;

    public <T> Mono<T> getBlogCallApi(ApiRequest<T> request, Class<T> response) {
        // WebClient.create() -> 빠르게 테스트할때 사용
        // bodyToMono : 1개의 값 리턴 / bodyToFlux : 복수의 값 리턴
        // Mono : Webflux 대표적 return 타입 파라미터를 한번에 전달하고, 한번에 받아온다.
        Mono<T> blogResponseMono = client.get()
                .uri(String.format("https://dapi.kakao.com/v2/search/blog?query=%s", request.getQuery()))
                .header(HttpHeaders.AUTHORIZATION, "KakaoAK 6958d15352ec2841aebdf071727bd632")
                .retrieve() // response개체의 body를 받아 디코딩
                .bodyToMono(response)
                .onErrorResume(throwable -> {
                    return Mono.error(new RuntimeException(throwable));
                });
        return blogResponseMono;
    }
}
