package com.unal.rest.product;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@Log4j2
public class ProductRest {

    // http://localhost:8080/product/rest
    @GetMapping("/product/rest")
    public ProductDto getProductRest() {

        ProductDto productDto = ProductDto
                .builder()
                .productId(0L)
                .productName("ürün adı")
                .price(1500)
                .trade("ürün marka")
                .build();

        return productDto;
    }

    // http://localhost:8080/product/server_client
    @PostMapping("/product/server_client")
    public ProductDto postProduct(@RequestBody ProductDto productDto) {
        log.error(productDto);
        return productDto;

    }

    // http://localhost:8080/product/server_client2
    @PutMapping("/product/server_client2")
    public ProductDto putProduct2(@RequestBody ProductDto productDto) {
        log.error(productDto);
        log.error("güncellendi");
        return productDto;
    }

    // http://localhost:8080/product/server_client3
    @DeleteMapping("/product/server_client3/{id}")
    public void deleteProduct3(@PathVariable(name = "id") Long id) {
        log.error("silindi: "+id);
    }



    // http://localhost:8080/server/header
    @GetMapping("/server/header")
    public ResponseEntity<?> getHeader(@RequestHeader(value = "headerKey",defaultValue = "default deger") String headerKey) {

        String headerData = "@restcontroller: "+headerKey;
        log.error(headerData);
        return null;
    }

    // http://localhost:8080/server/response/header
    @GetMapping("/server/response/header")
    public ResponseEntity<?> getHeader2() {

       return ResponseEntity.ok().header("server_key","serverdan gelen gizli bilgi").
               body("@restcontroller geldi");
    }


}
