package com.unal.security;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginSecurityController6 {

    // http://localhost:8080/register
    @GetMapping("/register")
    public String getRegister(@RequestParam(value = "error",required = false) String error, Model model) {

        if (error != null) {
            model.addAttribute("registerKey","kullanıcı adı veya şifre hatalı");
        }


        model.addAttribute("registerKey","");
        return "register";
    }



    // public
    // http://localhost:8080/security/public
    @GetMapping("/security/public")
    public String getPublic() {
        return "public";
    }

    // private
    // http://localhost:8080/security/private
    @GetMapping("/security/private")
    public String getPrivate() {
        return "private";
    }


}
