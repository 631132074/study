package com.bwl.study.model.vo;

import lombok.Data;

/**
 * @author BW Li
 * @date 2020-05-21 13:06
 * @description
 */
@Data
public class ResponseResult<T> {
    public static final String CODE_SUCCESS = "200";
    public static final String CODE_FAIL = "-100";
    public static final String MESSAGE_SUCCESS = "操作成功";
    public static final String MESSAGE_FAIL = "操作失败";
    private Integer flag;
    private String code;
    private String message;
    private T result;

    public ResponseResult() {
    }

    public static <T> ResponseResult<T> ok(T result) {
        return new ResponseResult(result);
    }

    public static <T> ResponseResult<T> ok() {
        return new ResponseResult(1, "200", "操作成功", (Object)null);
    }

    public static <T> ResponseResult<T> error() {
        return new ResponseResult(0, "-100", "操作失败", (Object)null);
    }

    public static <T> ResponseResult<T> error(String message) {
        return new ResponseResult(0, "-100", message, (Object)null);
    }

    public static <T> ResponseResult<T> build(String status, String message, T result) {
        return new ResponseResult(2, status, message, result);
    }

    public ResponseResult(Integer flag, String status, String message, T result) {
        this.flag = flag;
        this.code = status;
        this.message = message;
        this.result = result;
    }

    public ResponseResult(T result) {
        this.flag = 1;
        this.code = "200";
        this.message = "操作成功";
        this.result = result;
    }
}
