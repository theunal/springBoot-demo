package com.unal.Mvc;

import com.unal.Dto.AdminDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Log4j2
public class FormDataController {

    //http://localhost:8080/form
    @GetMapping("/form")
    public String getAdminForm(Model model) {
        AdminDto adminDto =null;


            adminDto = AdminDto.builder().adminId(0).name("admin adı giriniz").surname("admin soyad").build();


        model.addAttribute("form_key",adminDto);
        return "form";
    }

    //http://localhost:8080/form
    @PostMapping("/form")
    public String postAdminForm(Model model, AdminDto adminDto, BindingResult result) {
        log.info(adminDto);
        model.addAttribute("form_key",adminDto);
        return "form";
    }


}
