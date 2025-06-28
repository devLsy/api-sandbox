package com.lsy.menuapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 공통 유틸 패키지를 스캔대상에 추가
// (공통 유틸 모듈은 메인 메서드 하위가 아닌 다른 경로에 있기 때문에 각 api에서 추가 해줘야 함)
@SpringBootApplication(scanBasePackages = {"com.lsy.menuapi", "com.lsy.utils"})
public class MenuApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MenuApiApplication.class, args);
    }

}
