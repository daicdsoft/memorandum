package com.tencent.wxcloudrun.global;

import com.tencent.wxcloudrun.config.ApiResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalHandle {

    @ExceptionHandler(BusinessException.class)
    public ApiResponse handleEx(BusinessException e){


        return ApiResponse.error(e.getMessage());

    }

    @ExceptionHandler(Exception.class)
    public ApiResponse handleEx(Exception e){


        return ApiResponse.error(e.getMessage());
    }
}
