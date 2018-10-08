package com.spring.inventory.api.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.spring.inventory.api.interceptor.LoginInterceptor;

@Configuration
@ComponentScan("com.spring.inventory.api.interceptor")
public class WebMvcConfig extends WebMvcConfigurationSupport {
    
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        List<String> excludedPaths = new ArrayList<>();
        excludedPaths.add("/user/login");
        registry.addInterceptor(new LoginInterceptor()).excludePathPatterns(excludedPaths);
    }
}
