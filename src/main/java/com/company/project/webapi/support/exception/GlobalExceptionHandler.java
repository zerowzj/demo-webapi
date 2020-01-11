package com.company.project.webapi.support.exception;

import com.company.project.webapi.support.Results;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler({Throwable.class})
    public Map<String, Object> handle(Exception ex) {
        LOGGER.error("", ex);
        return Results.error("9999", "系统异常");
    }
}
