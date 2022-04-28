package com.unal.security;

import com.unal.Beans.PasswordBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//@EnableWebSecurity
//public class Authentication5 extends WebSecurityConfigurerAdapter {
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers("/","/index","/security/success","/security/public")
//                .permitAll()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .httpBasic();
//    }
//
//    @Autowired
//    PasswordBean passwordBean;
//
//    @Autowired
//    public void configureGlobalAddUser(AuthenticationManagerBuilder managerBuilder) throws Exception {
//        managerBuilder
//                .inMemoryAuthentication()
//                .withUser("yusuf")
//                .password(passwordBean.passwordEncoder().encode("12345"))
//                .roles("user");
//    }
//
//}
