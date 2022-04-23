package com.unal.dataMvc;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
@Log4j2
public class LoginEntityController {

    @Autowired
    LoginRepository loginRepository;

    // DB YE EKLİYOR
    // http://localhost:8080/login/saveadmin
    @GetMapping("/login/saveadmin")
    @ResponseBody
    public String saveAdmin() {
        LoginEntity entity = LoginEntity
                .builder()
                .id(0L)
                .name("Yusuf Ünal")
                .email("yusuf@gmail.com")
                .password(12345)
                .build();
        loginRepository.save(entity);

        log.info("Veritabanına eklendi: "+entity);
        return "Veritabanına eklendi: <br/><br/>"+entity;
    }

    // İD YE GÖRE BULUP RETURN EDİYOR
    // http://localhost:8080/login/getadmin/1
    @GetMapping("/login/getadmin/{id}")
    @ResponseBody
    public String getAdmin(@PathVariable(name = "id") Long id) {
        Optional<LoginEntity> getid = loginRepository.findById(id);

        if (!getid.isEmpty()) {
            LoginEntity entity = getid.get();

            log.info("Bulundu: "+entity);
            return "Bulundu :<br/><br/>"+entity;
        }

        log.info(id+" numaralı id'ye ait veri bulunamadi.");
        return id+" numaralı id'ye ait veri bulunamadi.";
    }

    // İD YE GÖRE BULUP SİLİYOR
    // http://localhost:8080/login/admindelete/1
    @GetMapping("/login/admindelete/{id}")
    @ResponseBody
    public String adminDelete(@PathVariable(name = "id") Long id) {
        Optional<LoginEntity> getid = loginRepository.findById(id);

        if (!getid.isEmpty()) {
            LoginEntity entity = getid.get();
            loginRepository.delete(entity);

            log.info("Silindi: "+entity);
            return "Silindi :<br/><br/>"+entity;
        }

        log.info(id+" numaralı id'ye ait veri bulunamadi.");
        return id+" numaralı id'ye ait veri bulunamadi.";
    }

    //  REQUESTPARAM İLE URLDEN İD NAME EMAİL PASSWORD ALIP GÜNCELLEDİK
    // http://localhost:8080/login/adminupdate?id=2&name=yusuf unal&email=yusufunal@gmail.com&password=123456
    @GetMapping("login/adminupdate")
    @ResponseBody
    public String adminUpdate(
            @RequestParam(name = "id") Long id,
            @RequestParam(name = "name") String name,
            @RequestParam(name = "email") String email,
            @RequestParam(name = "password") int password)
    {

        Optional<LoginEntity> get = loginRepository.findById(id);

        if (!get.isEmpty()) {

            LoginEntity entity = LoginEntity
                    .builder()
                    .id(id)
                    .name(name)
                    .email(email)
                    .password(password)
                    .build();

            loginRepository.save(entity);

            log.info("Güncelendi: "+entity);
            return "Güncelendi: <br/><br/>"+entity;
        }

        log.info(id+" numaralı id'ye ait veri bulunamadi.");
        return id+" numaralı id'ye ait veri bulunamadi.";
    }


    // http://localhost:8080/login/getall
    @GetMapping("login/getall")
    @ResponseBody
    public String getAll() {

        List<LoginEntity> entities = loginRepository.findAll();

        StringBuilder builder = new StringBuilder();
        builder.append("Tüm veritabanı elemanları listelendi: <br/><br/>");
        for (var entity : entities) {
            log.info(entity);
            builder.append(entity+"<br/>");
        }

        return builder+"";

    }








}
