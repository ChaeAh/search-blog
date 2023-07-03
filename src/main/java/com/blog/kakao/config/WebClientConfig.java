package com.blog.kakao.config;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

/**
 * @author chaeah.kim
 */

@Configuration
@Slf4j
public class WebClientConfig {

    /* webclient 생성 */
    @Bean
    public WebClient createWebClient() {
        HttpClient client = HttpClient.create()
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 30000)
                .doOnConnected(conn -> conn.
                        addHandlerLast(new ReadTimeoutHandler(30))
                        .addHandlerLast(new WriteTimeoutHandler(30)));
        return WebClient.builder()
                .clientConnector(new ReactorClientHttpConnector(client))
                .filter(ExchangeFilterFunction.ofRequestProcessor(
                        clientRequest -> {
                            log.info("==============REQUEST==============");
                            log.info("Request : {} {}", clientRequest.method(), clientRequest.url());
                            clientRequest.headers().forEach(
                                    (name, values) -> values.forEach(value -> log.info("{} : {}", name, value)));
                            return Mono.just(clientRequest);
                        }
                ))
                .filter(ExchangeFilterFunction.ofResponseProcessor(
                        clientResponse -> {
                            log.info("==============RESPONSE==============");
                            clientResponse.headers().asHttpHeaders().forEach(
                                    (name, values) -> values.forEach(value -> log.info("{} : {}", name, value)));
                            return Mono.just(clientResponse);
                        }
                ))
                .defaultHeader("user-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.87 Safari/537.3")
                .defaultCookie("httpclient-type", "webclient")
                .build();
    }

}


