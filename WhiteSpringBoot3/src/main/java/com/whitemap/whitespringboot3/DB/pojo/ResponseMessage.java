package com.whitemap.whitespringboot3.DB.pojo;

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

    public static<T> ResponseMessage<T> info(T data, String message, HttpStatus status) {
        return new ResponseMessage(status.value(), message, data);
    }

    public static<T> ResponseMessage<T> success(T data) {
        return info(data, "success!",HttpStatus.OK);
    }

    public static<T> ResponseMessage<T> failed(T data, String message) {
        return info(data, message, HttpStatus.INTERNAL_SERVER_ERROR);
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
