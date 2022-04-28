package com.unal.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {

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

    // success
    // http://localhost:8080/security/success
    @GetMapping("/security/success")
    public String getSuccess() {
        return "success";
    }

}
