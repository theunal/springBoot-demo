package com.unal.security;

//@EnableWebSecurity
//public class AddUserEncryped extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception{
//
//        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//
//        authenticationManagerBuilder
//                .inMemoryAuthentication()
//                .withUser("yusufunal")
//                .password(passwordEncoder.encode("12345"))
//                .roles("admin");
//
//    }
//
//}
