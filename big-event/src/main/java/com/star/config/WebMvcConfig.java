package com.star.config;

import com.star.interceptors.LoginInterceptor;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Classname: WebMvcConfig
 * @Date: 2024/11/27 20:33
 * @Author: 聂建强
 * @Description: SpringBoot的WebMvc配置类
 */
@Configuration  // 标明这是一个配置类
public class WebMvcConfig implements WebMvcConfigurer {

    @Resource
    private LoginInterceptor loginInterceptor;  // 自定义的登录拦截器
    // 重写添加拦截器方法
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 将自定义的登录拦截器注册到SpringBoot中，并配置拦截规则
        registry.addInterceptor(loginInterceptor)  // 拦截器注册
                .excludePathPatterns("/user/login","/user/register");  // 配置拦截器规则，放行那些接口，这里放行登录和注册接口
    }
}
