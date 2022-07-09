package com.hotelpms.config;

import com.hotelpms.security.filter.KaptchaFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final PMSUserDetailService pmsUserDetailService;

    @Autowired
    public SecurityConfig(PMSUserDetailService pmsUserDetailService) {
        this.pmsUserDetailService = pmsUserDetailService;
    }

    // 将自定义AuthenticationManager暴露在工厂中
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    // 自定义filter
    @Bean
    public KaptchaFilter kaptchaFilter() throws Exception {
        KaptchaFilter kaptchaFilter = new KaptchaFilter();
        kaptchaFilter.setFilterProcessesUrl("/login123");
        // 指定认证管理器
        kaptchaFilter.setAuthenticationManager(authenticationManagerBean());
        // 指定成功时处理
        kaptchaFilter.setAuthenticationSuccessHandler(((request, response, authentication) -> response.sendRedirect("/system.html")));
        // 指定失败时处理
        kaptchaFilter.setAuthenticationFailureHandler(((request, response, exception) -> response.sendRedirect("/login.html")));

        return kaptchaFilter;
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
                .mvcMatchers("/verify.jpg").permitAll()
                .mvcMatchers("/css/**", "/css2/**", "/font/**", "/fonts/**", "/image/**", "/images/**", "/img/**", "/js/**", "/js2/**", "/picture/**").permitAll()
                .anyRequest().authenticated()
                .and()
                // 表单登陆
                .formLogin()
                // 登陆页面
                .loginPage("/login.html")
                .and()
                //开启注销
                .logout()
                .logoutSuccessUrl("/index.html")
                .and()
                .csrf().disable();

        http.addFilterAt(kaptchaFilter(), UsernamePasswordAuthenticationFilter.class);

    }
}
