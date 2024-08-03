package com.example.fmarca.dto.vehicles;

import com.example.fmarca.domain.Vehicles;
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
                        vehicles.getType(),
                        vehicles.getEstablishment()
                );
    }
}
