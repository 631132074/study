package com.bwl.study.exception;


import com.bwl.study.enums.ResultEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author BW Li
 * @date 2019-01-18 13:33
 * @description
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BusinessException extends RuntimeException{

    /**
     *
     */
    private static final long serialVersionUID = 1777331244357341577L;
    private String code;

    /**
     * 继承exception，加入错误状态值
     *
     * @param codeEnum
     */
    public BusinessException(ResultEnum codeEnum) {
        super(codeEnum.getMessage());
        this.code = codeEnum.getCode();
    }

    /**
     * 自定义错误信息
     *
     * @param message
     * @param code
     */
    public BusinessException(String message, String code) {
        super(message);
        this.code = code;
    }

    /**
     * 业务异常
     *
     * @param message
     */
    public BusinessException(String message) {
        super(message);
        this.code = ResultEnum.BUSINESS_ERROR.getCode();

    }
}
