package com.unal.validation;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Log4j2
@Controller
public class RegisterController {

    // url ve model ortak
    //http://localhost:8080/validation
    @GetMapping("/validation")
    public String getValidation(Model model) {
        model.addAttribute("key_validation",new RegisterValidationDto());
        return "validation";
    }

    //http://localhost:8080/validation
    @PostMapping("/validation")
    public String postValidation(@Valid @ModelAttribute("key_validation") RegisterValidationDto dto, BindingResult result)  {

        if (result.hasErrors()) {

            log.error("hata olustu");
            return "validation";
        }
        log.info("basarılı: "+dto);

        return "success";
    }


}
