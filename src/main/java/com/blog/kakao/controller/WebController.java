package com.blog.kakao.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@Slf4j
public class WebController {

    @GetMapping("/webclient/{param}")
    public String testWebClient(@PathVariable String param, @RequestHeader HttpHeaders headers) {
        log.info(">>> Cookie :");
        return "ss";
    }
}
