package com.unal.login;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Login {

    @Email(message = "dogru e-mail giriniz.")
    @NotEmpty(message = "e-mail bos gecilemez")
    private String loginEmail;

    @NotEmpty(message = "şifre giriniz")
    private String loginPassword;
}
