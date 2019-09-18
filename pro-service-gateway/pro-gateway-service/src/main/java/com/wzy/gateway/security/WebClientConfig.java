package com.wzy.gateway.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
//
//    @Bean
//    WebClient webClient(ReactiveClientRegistrationRepository clientRegistrationRepository,
//                        ServerOAuth2AuthorizedClientRepository authorizedClientRepository) {
//        ServerOAuth2AuthorizedClientExchangeFilterFunction oauth =
//                new ServerOAuth2AuthorizedClientExchangeFilterFunction(clientRegistrationRepository, authorizedClientRepository);
//        oauth.setDefaultOAuth2AuthorizedClient(true);
//        return WebClient.builder()
//                .filter(oauth)
//                .build();
//    }
}
