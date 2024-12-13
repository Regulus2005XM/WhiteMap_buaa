package com.whitemap.whitespringboot3.exception;

import com.whitemap.whitespringboot3.DB.pojo.ResponseMessage;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandlerAdvice {

    Logger log = LoggerFactory.getLogger(GlobalExceptionHandlerAdvice.class);

    @ExceptionHandler(Exception.class)
    public ResponseMessage exception(Exception e, HttpServletRequest request, HttpServletResponse response) {
        log.error("出现异常：{}", e.getMessage(), e);
        return new ResponseMessage(500, "error", null);
    }
}
