package com.cl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.beans.factory.annotation.Value;

@Configuration
public class WebClientConfig {

    @Bean
    public WebClient webClient() {
        // DeepSeek API地址
        return WebClient.builder()
                .baseUrl("https://api.deepseek.com")
                .build();
    }

    @Value("${spring.ai.deepseek.api-key}")
    private String DeepSeekConfigUrl;

    @Value("${spring.ai.deepseek.api-host}")
    private String DeepSeekConfigHost;


    public String getDeepSeekConfigUrl() {
        return DeepSeekConfigUrl;
    }

    public String getDeepSeekConfigHost() {
        return DeepSeekConfigHost;
    }

}