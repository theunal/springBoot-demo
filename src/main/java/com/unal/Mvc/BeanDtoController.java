package com.unal.Mvc;


import com.unal.Beans.BeanConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BeanDtoController {

    @Autowired
    BeanConfig config;

    @GetMapping("/bean/beanDto")
    @ResponseBody
    public String getBeanDto() {

        return config.beanDto()+"";

    }

}
