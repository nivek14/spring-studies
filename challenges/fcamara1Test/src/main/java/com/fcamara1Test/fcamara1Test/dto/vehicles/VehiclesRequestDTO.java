package com.fcamara1Test.fcamara1Test.dto.vehicles;

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
    public String type;
}
