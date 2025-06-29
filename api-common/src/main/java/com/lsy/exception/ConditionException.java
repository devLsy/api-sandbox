package com.lsy.exception;

import com.lsy.handler.dto.ErrorDetail;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ConditionException extends RuntimeException implements LoggableException {

    private final ErrorDetail errorDetail;

    public ConditionException(ErrorDetail errorDetail) {
        this.errorDetail = errorDetail;
    }

    @Override
    public String getLogMessage() {
         return "[CONDITION CHECK] code=" + errorDetail.getCode() + ", key=" + errorDetail.getKey()
               + ", value=" + errorDetail.getValue() + ", message=" + errorDetail.getMessage();
    }
}
