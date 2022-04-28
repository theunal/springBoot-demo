package com.unal.rest.product;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Controller
public class ProductClient {

    @GetMapping("/d")
    @ResponseBody
    public ProductDto getProductRest() {

        String url = "http://localhost:8080/product/rest";
        RestTemplate restTemplate = new RestTemplate();
        //restTemplate.getForObject(url,ProductDto.class);

        ResponseEntity<ProductDto> responseEntity = restTemplate.exchange(url, HttpMethod.GET, HttpEntity.EMPTY, ProductDto.class);

        return responseEntity.getBody();
    }


    // http://localhost:8080/client/post
    @GetMapping("/client/post")
    @ResponseBody
    public String getProduct() {
        ProductDto productDto = ProductDto
                .builder()
                .productId(0L)
                .productName("laptop")
                .trade("asus")
                .price(15000)
                .build();

        String url = "http://localhost:8080/product/server_client";
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject(url,productDto,ProductDto.class)+"";
    }


    // http://localhost:8080/client/post2
    @GetMapping("/client/post2")
    public ProductDto getProduct2() {
        ProductDto productDto = ProductDto
                .builder()
                .productId(0L)
                .productName("laptop")
                .trade("asus")
                .price(15000)
                .build();

        String url = "http://localhost:8080/product/server_client";
        RestTemplate restTemplate = new RestTemplate();


        ResponseEntity<ProductDto> responseEntity =
                restTemplate.exchange(url,HttpMethod.POST,new HttpEntity<ProductDto>(productDto),ProductDto.class);

        return responseEntity.getBody();
    }

    // http://localhost:8080/client/put?name=laptop 2
    @GetMapping("/client/put")
    @ResponseBody
    public String putProduct3(@RequestParam(value = "name") String name) {
        ProductDto productDto = ProductDto
                .builder()
                .productId(0L)
                .productName(name)
                .trade("asus")
                .price(15000)
                .build();

        String url = "http://localhost:8080/product/server_client2";
        RestTemplate restTemplate = new RestTemplate();


        ResponseEntity<ProductDto> responseEntity =
                restTemplate.exchange(url,HttpMethod.POST,new HttpEntity<ProductDto>(productDto),ProductDto.class);

        return responseEntity.getBody()+"";
    }



    // http://localhost:8080/client/delete/1
    @GetMapping("/client/delete/{id}")
    @ResponseBody
    public String deleteProduct4(@PathVariable(name = "id") Long id) {


        String url = "http://localhost:8080/product/server_client3/"+id;
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.exchange(url,HttpMethod.DELETE,HttpEntity.EMPTY,Void.class);

        return "silindi";
    }

    // client server'a veri gönderiyor
    // http://localhost:8080/client/header
    @GetMapping("/client/header")
    @ResponseBody
    public String getClientHeader() {
        String url = "http://localhost:8080/server/header";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("headerKey","ben gizli bilgi");

        HttpEntity<String> stringHttpEntity = new HttpEntity<>("veri",httpHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url,HttpMethod.GET,stringHttpEntity,String.class);

        return responseEntity.getBody();
    }


    // server client'a veri gönderiyor
    // http://localhost:8080/client/header2
    @GetMapping("/client/header2")
    @ResponseBody
    public String getClientHeader2() {
        String url = "http://localhost:8080/server/response/header";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.exchange(url,HttpMethod.GET,HttpEntity.EMPTY,String.class);
        var gelen = responseEntity.getHeaders().getFirst("server_key");

        return "@controller: "+responseEntity.getBody()+", gelen data: "+gelen;

    }

    //Browserda saklanır: browser cache belleğini silerseniz silinir.

    //client Server'a Cookie gönderdi
    // http://localhost:8080/rest/response/cookie
    @GetMapping("/rest/response/cookie")
    @ResponseBody
    public ResponseEntity<?> getCookie() {
        return ResponseEntity
                .ok()
                .header(HttpHeaders.SET_COOKIE,"key_response_cookie")
                .body("@RestController ==> ");
    }


    // http://localhost:8080/controller/response/cookie/header2
    @GetMapping("/controller/response/cookie/header2")
    @ResponseBody
    public String getCookieController2() {
        String URL = "http://localhost:8080/rest/response/cookie2";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(URL, HttpMethod.GET, HttpEntity.EMPTY, String.class);
        String data=response.getHeaders().getFirst(HttpHeaders.SET_COOKIE);
        String body = response.getBody();
        return "@Controller ==> " + body+" "+data;
    }

}
