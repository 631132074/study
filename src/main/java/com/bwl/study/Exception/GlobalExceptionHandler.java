package com.bwl.study.Exception;

import com.bwl.study.model.vo.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
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
     * 参数校验统一异常处理
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseResult handleBindException(MethodArgumentNotValidException ex) {
        FieldError fieldError = ex.getBindingResult().getFieldError();
        log.warn("参数校验异常:{}({})", fieldError.getDefaultMessage(),fieldError.getField());
        return ResponseResult.error(fieldError.getDefaultMessage());
    }

}