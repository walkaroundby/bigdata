package com.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author luowei
 * @date 2018-12-04 20:00
 */
@EnableWebMvc
@EnableAsync
@EnableScheduling
public class WebConfig extends WebMvcConfigurerAdapter {
    @Autowired
    private AllInterceptor allInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(allInterceptor);
        super.addInterceptors(registry);
    }

}
