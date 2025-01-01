package com.whitemap.whitespringboot3.web.controller.response;

import org.springframework.http.HttpStatus;

/**
 * 网络通信中的返回体类
 * @param <T>
 */
public class ResponseMessage<T> {
    // 状态码
    private Integer status;
    // 信息
    private String message;
    // 数据包
    private T data;

    // 构造器
    public ResponseMessage(Integer status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }
    // 构造工厂
    public static<T> ResponseMessage<T> info(T data, String message,
                                             HttpStatus status) {
        return new ResponseMessage(status.value(), message, data);
    }

    // 成功状态
    public static<T> ResponseMessage<T> success(T data) {
        return info(data, "success!",HttpStatus.OK);
    }
    // 失败状态
    public static<T> ResponseMessage<T> failed(T data, String message) {
        return info(data, message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // getter方法
    public Integer getStatus() { return status; }
    public String getMessage() { return message; }
    public T getData() { return data; }
}
