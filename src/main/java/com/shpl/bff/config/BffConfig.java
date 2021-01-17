package com.shpl.bff.config;

import com.shpl.bff.provider.DataProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class BffConfig {

    @Bean
    public WebClient webClient(DataProperties dataProperties) {
        return WebClient.create(dataProperties.getBase());
    }

}
