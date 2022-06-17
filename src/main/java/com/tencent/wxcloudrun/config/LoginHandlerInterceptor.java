package com.tencent.wxcloudrun.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Slf4j
@Component
public class LoginHandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute("user");
        String servletPath = request.getServletPath();
        log.info("servletPath:{}",servletPath);
        if (user == null){
            request.setAttribute("msg", "没有权限");
            //未登录，返回登录页面
            request.getRequestDispatcher("/").forward(request, response);
//            request.getRequestDispatcher()
            log.info("request:{}",request);
            return false;
        }

        return true;
    }
}
