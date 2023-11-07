package kakao.controller;

import kakao.biz.CallApiClient;
import kakao.model.BlogRequest;
import kakao.model.BlogResponse;
import kakao.service.BlogSearchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/v1")
public class SearchController {

    private final CallApiClient client;
    private final BlogSearchService blogSearchService;
    private final String LOG_PREFIX = "[SEARCH]";

    @GetMapping("/search")
    public BlogResponse commonBlogSearch(@RequestBody BlogRequest request) {
        log.info(LOG_PREFIX + " START");

        blogSearchService.saveBlogSearchHistory(request);

        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        queryParams.add("query", request.getQuery());
        queryParams.add("sort", request.getSortType().toLowerCase());
        queryParams.add("page", String.valueOf(request.getPage()));
        queryParams.add("size", String.valueOf(request.getSize()));

        BlogResponse response = client.callKakaoBlogApi(HttpMethod.GET, queryParams, BlogResponse.class).block();
        response.setTransactionId(request.getTransactionId());

        blogSearchService.saveBlogSearch(response);

        return response;
    }

    @GetMapping("/popular")
    public BlogResponse popularBlogList() {

        return null;
    }

}
