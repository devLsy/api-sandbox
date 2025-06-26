package com.lsy.utils.cors;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

// CORS 허용 설정 클래스 (WebMvcConfigurer 구현)
@Configuration
@EnableConfigurationProperties(CorsConfig.CorsProperties.class) // CorsProperties를 설정 프로퍼티로 등록
@RequiredArgsConstructor
public class CorsConfig implements WebMvcConfigurer {

    private final CorsProperties corsProperties;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                // application.yml 또는 application-<profile>.yml에 정의된
                // cors.allowed-origins 목록을 프로파일에 따라 자동으로 바인딩하여 사용
                .allowedOrigins(corsProperties.allowedOrigins.toArray(new String[0]))
                .allowedMethods("*")
                .allowedHeaders("*")
                .allowCredentials(true);
    }

    // application.yml의 cors 프로퍼티 바인딩용 클래스
    @ConfigurationProperties(prefix = "cors")
    @Getter @Setter
    public static class CorsProperties {
        private List<String> allowedOrigins;    // 허용할 CORS origin 목록
    }
}
