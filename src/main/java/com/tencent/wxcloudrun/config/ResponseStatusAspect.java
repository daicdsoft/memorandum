package com.tencent.wxcloudrun.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
@Slf4j
public class ResponseStatusAspect {

    @Autowired
    HttpServletRequest request;

    @AfterReturning(value = "@annotation(responseStatus)")
    public Object aroundMethod(JoinPoint point, ResponseStatus responseStatus) {
        try {
            String ip = request.getRemoteAddr();
            log.info(String.format("请求ip=%s,状态code：%s", ip, responseStatus.code()));
            //执行对象方法
//            Object proceed = point.proceed();
//            log.info(String.format("执行结果为=%s", proceed));
            //必须将原来方法的结果返回，除非你需要改变返回结果
            return point;
        } catch (Throwable throwable) {
            log.error("发生异常，异常=" + throwable.getMessage());
        }
        return "1222";
    }

}
