package com.unal.rest.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Data
@Builder
@Log4j2
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private long productId;
    private String productName;
    private double price;
    private String trade;


}
