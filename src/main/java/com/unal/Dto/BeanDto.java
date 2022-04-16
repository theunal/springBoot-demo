package com.unal.Dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.logging.Logger;

@Data
@Builder
@Log4j2
@AllArgsConstructor
@NoArgsConstructor
public class BeanDto {

    private int id;
    private String beanName;
    private String beanData;

    public void initialBeanMethod() {
        log.error("Bean başladı");
        System.out.println("Bean başladı");
    }

    public void destroyBeanMethod() {
        log.error("Bean bitti");
        System.out.println("Bean bitti");
    }

   // @Autowired
    //Logger LOG;
//    public BeanDto() {
//        LOG.info("Log dosyam constructordan geldi");
//    }
   // @PostConstruct
//    public void init() {
//        LOG.info("Log dosyam constructordan geldi");
//    }

//    public static void main(String[] args) {
//        BeanDto beanDto = new BeanDto();
//        System.out.println(beanDto);
//    }
}
