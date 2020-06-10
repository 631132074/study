package com.bwl.study.exception.hander;

import com.bwl.study.exception.BusinessException;
import com.bwl.study.model.vo.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author BW Li
 * @date 2020-05-21 13:47
 * @description
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 统一异常处理
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseResult handleBindException(Exception e) {

        if (e instanceof MethodArgumentNotValidException) {
            //参数校验统一异常处理
            MethodArgumentNotValidException myException = (MethodArgumentNotValidException) e;
            FieldError fieldError = myException.getBindingResult().getFieldError();
            log.warn("参数校验异常:{}({})", fieldError.getDefaultMessage(), fieldError.getField());
            return ResponseResult.error(fieldError.getField() + fieldError.getDefaultMessage());
        } else if (e instanceof BusinessException) {
            //统一运行时异常处理
            log.warn("[运行时异常] {}({})", ((BusinessException) e).getCode(), e.getMessage());
            return ResponseResult.error(((BusinessException) e).getCode(), e.getMessage());
        } else {
            //其他异常处理
            log.warn("[系统异常] {}", e.getMessage());
            return ResponseResult.error(e.getMessage());
        }
    }

}