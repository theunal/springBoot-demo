package com.unal.dataMvc;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@Log4j2
public class LoginController1 {


    //http://localhost:8080/mvcdatalogin
    @GetMapping("/mvcdatalogin")
    public String getValidation(Model model) {
        model.addAttribute("mvc_data_key",new LoginDto1());
        return  "mvcdatalogin";
    }





    //http://localhost:8080/mvcdatalogin
    @PostMapping("/mvcdatalogin")
    public String postValidation(@Valid @ModelAttribute("mvc_data_key") LoginDto1 loginDto1, BindingResult result) {

        if (result.hasErrors()) {
            log.error("hata olustu");
            return "mvcdatalogin";
        }

        // database işlemleri kısmı
        log.info(loginDto1);
        return "mvcdataloginsuccess";
    }


}
