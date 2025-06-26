package com.lsy.utils.cors;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
// cros 허용 설정
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                // 허용할 origin(우선은 기존 소스와 동일하게 적용했음)
                .allowedOrigins(
                "https://localhost:3005",
                "https://localhost:3006",
                "https://kepass-admin-dev.koreanair.com",    // admin dev
                "https://apidev.koreanair.com",              // apigee dev
                "https://kepass-admin.koreanair.com",       // admin prd
                "https://api.koreanair.com"                 // apigee prd
                )
                .allowedMethods("*")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}
