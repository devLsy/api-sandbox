package com.lsy.menuapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 공통 유틸 패키지를 스캔대상에 추가
@SpringBootApplication(scanBasePackages = {"com.lsy.menuapi", "com.lsy.utils"})
public class MenuApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MenuApiApplication.class, args);
    }

}
