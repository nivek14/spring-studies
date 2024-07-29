package com.example.fmarca.dto.vehicles;

import com.example.fmarca.domain.VehiclesType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VehiclesRequestDTO {
    public String brand;
    public String model;
    public String color;
    public String plate;
    public VehiclesType type;
}
