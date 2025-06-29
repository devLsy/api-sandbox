package com.lsy.handler;

import com.lsy.constant.ErrorMessages;
import com.lsy.exception.ConditionException;
import com.lsy.response.CommonErrorResponse;
import com.lsy.utils.LogUtils;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
@Slf4j
public class ApiExceptionHandler {
    
    // 커스텀 예외
    @ExceptionHandler(value = ConditionException.class)
    public ResponseEntity<CommonErrorResponse> conditionException(ConditionException ce, HttpServletRequest httpServletRequest) {
        LogUtils.logError(ce);

        return new ResponseEntity<>(
                CommonErrorResponse.builder()
                        .status(HttpStatus.UNPROCESSABLE_ENTITY.toString())
                        .path(httpServletRequest.getRequestURI())
                        .error(ErrorMessages.CONDITION_FAILED)
                        .info(List.of(ce.getErrorDetail()))
                        .build()
                , HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
