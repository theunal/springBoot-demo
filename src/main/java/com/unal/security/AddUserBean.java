package com.unal.security;

import com.unal.Beans.PasswordBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

//@EnableWebSecurity
//public class AddUserBean extends WebSecurityConfigurerAdapter {
//
//
//    @Autowired
//    PasswordBean passwordBean;
//
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception{
//       authenticationManagerBuilder
//              .inMemoryAuthentication()
//               .withUser("yusufunal")
//             .password(passwordBean.passwordEncoder().encode("12345"))
//               .roles("admin");
//   }
//
//}
