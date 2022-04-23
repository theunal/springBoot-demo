package com.unal.rest;


import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Log4j2
public class ComputerRest { // server


    // http://localhost:8080/rest1
    @GetMapping("/rest1")
    public String rest1() {

        return "{\n" +
                "\n" +
                "\n" +
                "  \"adı\" : \"yusuf\",\n" +
                "  \"isLogin\" : true,\n" +
                "  \"code\" : 44\n" +
                "}";
    }


    // http://localhost:8080/rest2
    @GetMapping("/rest2")
    public ComputerDto rest2() {

        ComputerDto computerDto = ComputerDto
                .builder()
                .computerId(0L)
                .computerName("asus")
                .computerPrice(4500)
                .build();

        return computerDto;
    }

    // json
    // http://localhost:8080/rest3
    @GetMapping(value = "/rest3",produces = MediaType.APPLICATION_JSON_VALUE)
    public ComputerDto rest3() {

        ComputerDto computerDto = ComputerDto
                .builder()
                .computerId(0L)
                .computerName("asus")
                .computerPrice(4500)
                .build();

        return computerDto;
    }

    // xml
    // http://localhost:8080/rest4
    @GetMapping(value = "/rest4",produces = MediaType.APPLICATION_XML_VALUE)
    public ComputerDto rest4() {

        ComputerDto computerDto = ComputerDto
                .builder()
                .computerId(0L)
                .computerName("asus")
                .computerPrice(4500)
                .build();

        return computerDto;
    }

    // path variable
    // http://localhost:8080/rest5/9
    @GetMapping("/rest5/{id}")
    public ComputerDto rest5(@PathVariable(name = "id") Long id) {

        ComputerDto computerDto = ComputerDto
                .builder()
                .computerId(id)
                .computerName("asus")
                .computerPrice(4500)
                .build();

        return computerDto;
    }

    // path variable 2
    // http://localhost:8080/rest6/9
    @GetMapping({"/rest6/{id}", "/rest6"})
    public ComputerDto rest6(@PathVariable(name = "id",required = false) Long id) {
        ComputerDto computerDto = null;
        if (id == null) {
          log.error("hata >> id : null");
        }else  {
            computerDto = ComputerDto
                    .builder()
                    .computerId(id)
                    .computerName("asus")
                    .computerPrice(4500)
                    .build();
        }
        return computerDto;
    }


    // http://localhost:8080/rest7
    @GetMapping("/rest7")
    public List<ComputerDto> rest7() {

        List<ComputerDto> list = new ArrayList<>();
        list.add(ComputerDto.builder().computerId(0L).computerName("asus").computerPrice(4500).build());
        list.add(ComputerDto.builder().computerId(1L).computerName("asus").computerPrice(9552).build());
        list.add(ComputerDto.builder().computerId(2L).computerName("asus").computerPrice(7486).build());
        list.add(ComputerDto.builder().computerId(3L).computerName("asus").computerPrice(13500).build());
        list.add(ComputerDto.builder().computerId(4L).computerName("asus").computerPrice(45896).build());
        return list;

    }




















}
