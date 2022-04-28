package com.unal.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//@EnableWebSecurity
//public class AddUserNoEncryped extends WebSecurityConfigurerAdapter {
//
////    @Override
//////    protected AuthenticationManager authenticationManager() throws Exception {
//////        return super.authenticationManager();
//////    }
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception{
//
//        authenticationManagerBuilder
//                .inMemoryAuthentication()
//                .withUser("yusufunal")
//                .password("{noop}12345")
//                .roles("admin");
//
//    }
//}
