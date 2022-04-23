package com.unal.dataMvc;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Log4j2
public class LoginDto1 {

    private Long id;

    @NotEmpty(message = "E-mail girmediniz.")
    @Email(message = "Dogru mail girilmedi")
    private String email;

    @NotEmpty(message = "Şifre girmediniz.")
    private String password;

}
