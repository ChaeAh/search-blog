package com.blog.kakao.config;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

/**
 * @author chaeah.kim
 */

@Configuration
public class WebClientConfig {

    @Bean
    public WebClient createWebClient() {
        HttpClient client = HttpClient.create()
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 30000)
                .doOnConnected(conn -> conn.
                        addHandlerLast(new ReadTimeoutHandler(30))
                        .addHandlerLast(new WriteTimeoutHandler(30)));
        return WebClient.builder()
                .clientConnector(new ReactorClientHttpConnector(client))
                .build();
    }

}


