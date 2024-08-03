package com.example.fmarca.dto.vehicles;

import com.example.fmarca.domain.Establishment;
import com.example.fmarca.domain.VehiclesType;
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
    private int occupying;
    private VehiclesType type;
    private Establishment establishment;
}
