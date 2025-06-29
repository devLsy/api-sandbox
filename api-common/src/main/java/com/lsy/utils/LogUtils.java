package com.lsy.utils;

import com.lsy.exception.LoggableException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogUtils {

    public static void logError(Exception e) {
        if(e instanceof LoggableException loggable) {
            // 커스텀 예외
            log.error(loggable.getLogMessage());
        } else {
            // 일반 예외
            log.error("[ERROR] {} - {}", e.getClass().getSimpleName(), e.getMessage(), e);
        }
    }
}
