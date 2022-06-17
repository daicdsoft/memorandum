package com.tencent.wxcloudrun.config;

import com.tencent.wxcloudrun.constant.ResponseConstant;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ResponseStatus {

    String code();
}
