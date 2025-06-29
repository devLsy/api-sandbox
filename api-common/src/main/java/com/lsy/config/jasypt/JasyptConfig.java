package com.lsy.config.jasypt;

import lombok.extern.slf4j.Slf4j;
import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class JasyptConfig {

    // vm 옵션으로 전달받은 개인키
    @Value("${jasypt.password}")
    private String jasyptPassword;
    // 암복호화 객체를 빈으로 등록 후 application.yml에서 사용할 수 있도록 설정
    @Bean(name = "jasyptStringEncryptor")
    public StringEncryptor StringEncryptor() {
         SimpleStringPBEConfig config = new SimpleStringPBEConfig();
         config.setPassword(jasyptPassword);        // 암호화 개인키(절대 노출 금지)
         config.setAlgorithm("PBEWithMD5AndDES");   // 암호화 알고리즘
         config.setKeyObtentionIterations("1000");  // 해싱 반복 횟수
         config.setPoolSize("1");                   // Encryptor 풀 크기
         config.setProviderName("SunJCE");          // 암호화 Provider
         config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");   // salt 생성 클래스
         config.setStringOutputType("base64");      // 암호화 결과를 Base64방식으로 한번 더 인코딩

         PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
         encryptor.setConfig(config);
         return encryptor;
    }

}
