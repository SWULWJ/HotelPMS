package com.hotelpms.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final PMSUserDetailService pmsUserDetailService;

    @Autowired
    public SecurityConfig(PMSUserDetailService pmsUserDetailService) {
        this.pmsUserDetailService = pmsUserDetailService;
    }

    //自定义全局AuthenticationManager，使用自定义pmsUserDetailService
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(pmsUserDetailService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .mvcMatchers("/").permitAll()
                .mvcMatchers("/index.html").permitAll()
                .mvcMatchers("/login.html").permitAll()
                .mvcMatchers("/css/**", "/css2/**", "/font/**", "/fonts/**", "/image/**", "/images/**", "/img/**", "/js/**", "/js2/**", "/picture/**").permitAll()
                .anyRequest().authenticated()
                .and()
                // 表单登陆
                .formLogin()
                // 登陆页面
                .loginPage("/login.html")
                // 处理登陆的请求
                .loginProcessingUrl("/login123")
                // 登陆成功跳转页面
                .defaultSuccessUrl("/system.html")
                // 登陆失败跳转页面
                .failureUrl("/login.html")
                .and()
                //开启注销
                .logout()
                .logoutSuccessUrl("/index.html")
                .and()
                .csrf().disable();

    }
}
