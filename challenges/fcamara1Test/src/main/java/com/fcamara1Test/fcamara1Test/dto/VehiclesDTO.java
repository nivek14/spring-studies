package com.fcamara1Test.fcamara1Test.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class VehiclesDTO {
    private long id;
    private String brand;
    private String model;
    private String color;
    private String plate;
    private String type;
}
