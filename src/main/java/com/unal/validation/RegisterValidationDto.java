package com.unal.validation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import javax.validation.constraints.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Log4j2
public class RegisterValidationDto {

    private int registerId;

    @NotEmpty(message = "kullanıcı adı ve soyadını bos gecilemez")
    private String registerNameSurname;

    @NotEmpty(message = "email bos gecilemez")
    @Email(message = "uygun formatta mail giriniz")
    private String registerEmailAddress;

    @Min(value = 18,message = "18 yasından kücükler basvuramaz")
    @Max(value = 50,message = "50 yasından büyükler basvuramaz")
    private int registerAge;

    @NotEmpty(message = "telefon numarası bos gecilemez")
    //@Pattern(regexp = "[0-9\\s][9]]")
    private String registerPhone;

    @NotEmpty(message = "mesaj bos gecilemez")
    @Size(min = 1,max = 100)
    private String registerMessages;

    public String getNowDate() {
        Locale locale = new Locale("tr","TR");
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss",locale);
        String change = formatter.format(new Date(System.currentTimeMillis()));
        return change;
    }
    private String creationDate = getNowDate();



}
