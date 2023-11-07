package kakao.biz;

import kakao.model.ApiRequest;
import kakao.model.HttpHeaders;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import java.net.URI;

@Service
@RequiredArgsConstructor
public class CallApiClient {

    private final WebClient client;

    public <T> Mono<T> callKakaoBlogApi(HttpMethod httpMethod, MultiValueMap<String, String> queryParams, Class<T> response) {
        URI url = UriComponentsBuilder.fromUriString("https://dapi.kakao.com/v2/search/blog")
                .queryParams(queryParams)
                .build()
                .encode()
                .toUri();

        return this.client.mutate()
                .build()
                .method(httpMethod)
                .uri(url)
                .headers(httpHeaders -> {
                    httpHeaders.add(HttpHeaders.AUTHORIZATION, "KakaoAK 6958d15352ec2841aebdf071727bd632");
                })
                .retrieve()
                .bodyToMono(response)
                .onErrorResume(throwable -> {
                    return Mono.error(new RuntimeException(throwable));
                });
    }
}
