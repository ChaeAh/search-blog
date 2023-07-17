package kakao.controller;

import kakao.biz.BizCallAPI;
import kakao.model.BlogRequest;
import kakao.model.BlogResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
@RequiredArgsConstructor
public class WebClientController {

    private final BizCallAPI bizCallAPI;

    @GetMapping("/search")
    public BlogResponse commonBlogSearch(@RequestBody BlogRequest request) {
        log.info("bodyToMono TEST START");
        Mono<BlogResponse> blogResponseMono = bizCallAPI.getBlogCallApi(request, BlogResponse.class);
        BlogResponse blogResponse = blogResponseMono.block();

        return blogResponse;
    }

}
