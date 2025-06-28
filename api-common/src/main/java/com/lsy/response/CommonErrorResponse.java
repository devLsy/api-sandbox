package com.lsy.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Setter @Getter @ToString
@NoArgsConstructor @AllArgsConstructor
public class CommonErrorResponse {

    // 빌더로 객체 생성 시에도 현재시간을 기본값으로 넣어주기 위함
    // (이 옵션 없으면 객체 생성 시 값 파라미터로 받지 않으면 필드값 세팅 안됨)
    @Builder.Default
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime timestamp = LocalDateTime.now();

    private String status;

    private String error;

    private String path;

    private List<?> info;

}
