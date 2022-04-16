package com.unal.login;

import com.unal.validation.RegisterValidationDto;
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
public class LoginController {

    //http://localhost:8080/login
    @GetMapping("/login")
    public String getLogin(Model model) {
        model.addAttribute("loginKey",new Login());
        return "login";
    }

    //http://localhost:8080/login
    @PostMapping ("/login")
    public String postLogin(@Valid @ModelAttribute("loginKey") Login login, BindingResult result) {

        if (result.hasErrors()) {
            log.error("hata olustu");
            return "login";
        }

        if (login.getLoginEmail().equals("root@root") && login.getLoginPassword().equals("root")) {
            log.info("login basarılı: "+ login);
            return "loginsuccess";
        }

        return "login";


    }




}
