package com.hotelpms.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    //页面跳转
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/login.html").setViewName("login");
        registry.addViewController("/system.html").setViewName("sys");
        registry.addViewController("/staffInfo.html").setViewName("concierge");
        registry.addViewController("/roomManage.html").setViewName("roomType");
        registry.addViewController("/storeManage.html").setViewName("store");
        registry.addViewController("/tenantManage.html").setViewName("tenantInfo");
        registry.addViewController("/checkIn.html").setViewName("roomInfo");
        registry.addViewController("/error404.html").setViewName("error404");
    }

    //配置静态资源
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
//        WebMvcConfigurer.super.addResourceHandlers(registry);
//    }


//拦截器
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new LoginHandlerInterceptor()).
//                addPathPatterns("/**").
//                excludePathPatterns("/index.html",
//                        "/",
//                        "/login.html",
//                        "/userLogin",
//                        "/css/**",
//                        "/css2/**",
//                        "/font/**",
//                        "/fonts/**",
//                        "/images/**",
//                        "/image/**",
//                        "/img/**",
//                        "/js/**",
//                        "/js2/**",
//                        "/picture/**");
//    }
}