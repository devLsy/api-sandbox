package com.lsy.handler.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
public class ErrorDetail {
    private String message;       // 사용자에게 보여줄 메시지
    private String key;           // 어떤 필드나 조건에서 에러가 발생했는지 (예: "userCount")
    private Object value;         // 해당 필드의 값 (예: 5명)
    private String code;          // 비즈니스 에러 코드 (예: "RD01")
}
