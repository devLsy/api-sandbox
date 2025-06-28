package com.lsy.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 공통 API 응답 클래스(응답 성공 케이스 처리)
// 추후 리팩토링 예정
@Data
@NoArgsConstructor
public class CommonResponse<T> {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime time = LocalDateTime.now();

    private String resultMessage = "SUCCESS";
    private String statusCode = HttpStatus.OK.toString();
    private String message = "정상 처리입니다.";

    private long contentCnt;

    private Map<String, Object> paging = new HashMap<>();
    private List<T> content = new ArrayList<>();

    public CommonResponse(String mesage) {
        this.message = mesage;
    }
    // 리스트 응답
    public CommonResponse(List<T> resultList) {
        this.content = resultList;
        this.contentCnt = resultList.size();
    }
    // 단일 값 응답
    public CommonResponse(T result) {
        if (result != null) {
            this.content.add(result);
            this.contentCnt = 1;
        }
    }
    // 페이지네이션 포함 결과값 응답
    public CommonResponse(Page<T> result) {
        this.content = result.getContent();
        this.contentCnt = result.getTotalElements();
        this.paging.put("pageCount", result.getTotalElements());
        this.paging.put("pageNumber", result.getNumber());
        this.paging.put("isLastPage", result.isLast());
        this.paging.put("isFirstPage", result.isFirst());
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
