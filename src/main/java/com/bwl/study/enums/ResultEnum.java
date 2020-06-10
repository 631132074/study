package com.bwl.study.enums;

/**
 * @author BW Li
 * @date 2019-01-18 13:34
 * @description
 */
public enum ResultEnum {
    //全局返回码标识
    SUCCESS("200", "成功"),
    DATA_ERROR("600", "数据异常"),
    NO_HANDLER_FOUND("404", "404"),
    BUSINESS_ERROR("-100", "操作失败"),
    REMOTE_INTERFACE_ERROR("700", "接口调用异常"),
    DECRYPT_ERROR("702", "解密失败"),
    ENCRYPT_ERROR("701", "加密失败"),
    UNKNOW_ERROR("500", "未知错误"),
    UNDEFINED_ERROR("503", "文件不存在"),
    PARAM_ERROR("501", "传参错误"),
    TOKEN_ERROR("502", "token失效"),
    ;

    private String code;
    private String message;

    ResultEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
