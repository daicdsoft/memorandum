package com.tencent.wxcloudrun.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        WebMvcConfigurer webMvcConfigurer = new WebMvcConfigurer() {
            @Autowired
            private LoginHandlerInterceptor loginInterceptor;
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                //由于SpringBoot已经做好了静态资源的映射，拦截器不会拦截静态资源
                //addPathPatterns()表示会对那种类型的映射进行拦截，"/**"表示/全部拦截
                //excludePathPatterns()表示排除一些不拦截的
//                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
//                        .excludePathPatterns("/index", "/", "/user/login");

                InterceptorRegistration registration = registry.addInterceptor(loginInterceptor);
                registration.addPathPatterns("/**");//所有路径都被拦截
                registration.excludePathPatterns( // 添加不拦截路径
                        "/index.html", "/", "/user/login","/css/**","/img/**","/fonts/**","/js/**","/favicon.ico"
                );
            }

            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("index");
                registry.addViewController("/index").setViewName("index");
            }

        };
        return webMvcConfigurer;
    }
}
