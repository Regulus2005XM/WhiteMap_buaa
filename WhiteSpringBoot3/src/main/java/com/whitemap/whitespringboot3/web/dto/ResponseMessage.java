package com.whitemap.whitespringboot3.pojo;

import org.springframework.http.HttpStatus;

public class ResponseMessage<T> {
    private Integer status;
    private String message;
    private T data;

    public ResponseMessage(Integer status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public static<T> ResponseMessage<T> success(T data) {
        return new ResponseMessage(HttpStatus.OK.value(), "success!", data);
    }

    public Integer getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }
}
