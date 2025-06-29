package com.lsy.exception;

import com.lsy.handler.dto.ErrorDetail;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class ConditionException extends RuntimeException implements LoggableException {

    private final ErrorDetail errorDetail;

    @Override
    public String getLogMessage() {
         return "[CONDITION CHECK] code=" + errorDetail.getCode() + ", key=" + errorDetail.getKey()
               + ", value=" + errorDetail.getValue() + ", message=" + errorDetail.getMessage();
    }
}
