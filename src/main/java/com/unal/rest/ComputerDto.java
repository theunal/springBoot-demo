package com.unal.rest;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
class ComputerDto {

    private Long computerId;
    private String computerName;
    private double computerPrice;

}