package com.mysite.matdori.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 모든 요청 경로에 대해서
                .allowedOrigins("*") // 모든 출처
                .allowedMethods("*"); // 모든 HTTP 메소드
    }
}