package com.unal.Beans;


import com.unal.Dto.BeanDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean(initMethod = "initialBeanMethod", destroyMethod = "destroyBeanMethod")
    public BeanDto beanDto() {
        return BeanDto.builder().id(44).beanName("Bean name").beanData("Bean data").build();
    }

}
