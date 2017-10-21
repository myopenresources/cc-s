package com.cjh.cc.config.mvc;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 全局异常处理
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    /**
     * 异常处理实现
     */
    @ExceptionHandler(value=Exception.class)
    public Map<String,Object> resolveException(Exception exception) throws Exception
    {
        Map<String,Object> errorResult = new HashMap<>();
        errorResult.put("message", exception.getMessage());
        errorResult.put("localizedMessage", exception.getLocalizedMessage());
        errorResult.put("cause", exception.getCause());
        errorResult.put("suppressed", exception.getSuppressed());
        //errorResult.put("stackTrace", exception.getStackTrace());
        exception.printStackTrace();
        return errorResult;
    }
}
