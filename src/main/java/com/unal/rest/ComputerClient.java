package com.unal.rest;

//server - restcontroller >> üreten
// client - controller >> tüketen


import lombok.extern.log4j.Log4j2;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
@Log4j2
public class ComputerClient { // client

    // http://localhost:8080/client1
    @GetMapping("/client1")
    @ResponseBody
    public String client1() {
       // String url = "http://localhost:8080/rest1";
        String url = "https://api.github.com/users";
        RestTemplate template = new RestTemplate();
        String json = template.getForObject(url,String.class);

        return json;
    }



    // http://localhost:8080/client2
    @GetMapping("/client2")
    @ResponseBody
    public String client2() {

        String url = "http://localhost:8080/rest2";

        RestTemplate template = new RestTemplate();
        ComputerDto computerDto = template.getForObject(url,ComputerDto.class);


        return computerDto+"";
    }


    // http://localhost:8080/client3
    @GetMapping("/client3")
    @ResponseBody
    public ComputerDto client3() {

        String url = "http://localhost:8080/rest2";
        RestTemplate template = new RestTemplate();

        ResponseEntity<ComputerDto> responseEntity = template.exchange(url, HttpMethod.GET, HttpEntity.EMPTY,ComputerDto.class);
        ComputerDto computerBody = responseEntity.getBody();

        return computerBody;
    }


    // http://localhost:8080/client7
    @GetMapping("/client7")
    @ResponseBody
    public List<ComputerDto> client7() {

        String url = "http://localhost:8080/rest7";

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<List<ComputerDto>> responseEntity =
                restTemplate.exchange(url, HttpMethod.GET, HttpEntity.EMPTY, new ParameterizedTypeReference<List<ComputerDto>>() {
                });

        List<ComputerDto> listBody = responseEntity.getBody();
        for (ComputerDto item : listBody) {
            log.info(item);
        }

        return listBody;
    }








}
