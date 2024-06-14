package com.fcamara1Test.fcamara1Test.dto.vehicles;

import com.fcamara1Test.fcamara1Test.domain.Vehicles;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VehiclesResponseDTO {

    private VehiclesDTO vehiclesDTO;

    public VehiclesResponseDTO(Vehicles vehicles){
        this.vehiclesDTO =
                new VehiclesDTO(
                        vehicles.getId(),
                        vehicles.getBrand(),
                        vehicles.getModel(),
                        vehicles.getColor(),
                        vehicles.getPlate(),
                        vehicles.getType()
                );
    }
}
