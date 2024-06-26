package com.fcamara1Test.fcamara1Test.services;

import com.fcamara1Test.fcamara1Test.domain.Establishment;
import com.fcamara1Test.fcamara1Test.domain.Vehicles;
import com.fcamara1Test.fcamara1Test.dto.vehicles.VehiclesDTO;
import com.fcamara1Test.fcamara1Test.dto.vehicles.VehiclesIdDTO;
import com.fcamara1Test.fcamara1Test.dto.vehicles.VehiclesRequestDTO;
import com.fcamara1Test.fcamara1Test.dto.vehicles.VehiclesResponseDTO;
import com.fcamara1Test.fcamara1Test.repositories.VehiclesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VehiclesService {

    private final VehiclesRepository vehiclesRepository;

    public VehiclesResponseDTO getVehicleDetail(long id){
        Vehicles vehicle = this.getVehicleById(id);
        return new VehiclesResponseDTO(vehicle);
    }

    public VehiclesIdDTO createVehicle(VehiclesRequestDTO vehiclesRequestDTO){

        Vehicles vehicles = new Vehicles();

        vehicles.setBrand(vehiclesRequestDTO.getBrand());
        vehicles.setModel(vehiclesRequestDTO.getModel());
        vehicles.setColor(vehiclesRequestDTO.getColor());
        vehicles.setPlate(vehiclesRequestDTO.getPlate());
        vehicles.setType(vehiclesRequestDTO.getType());

        this.vehiclesRepository.save(vehicles);

        return new VehiclesIdDTO(vehicles.getId());

    }

    public int updateVehicle(VehiclesDTO vehiclesDTO){

        Optional<Vehicles> optional = Optional.ofNullable(this.getVehicleById(vehiclesDTO.getId()));

        if(optional.isPresent()){
            Vehicles vehicles = new Vehicles();
            vehicles.setId(vehiclesDTO.getId());
            vehicles.setBrand(vehiclesDTO.getBrand());
            vehicles.setModel(vehiclesDTO.getModel());
            vehicles.setColor(vehiclesDTO.getColor());
            vehicles.setPlate(vehiclesDTO.getPlate());
            vehicles.setType(vehiclesDTO.getType());
            this.vehiclesRepository.save(vehicles);
            return 1;
        }
        else return 0;

    }

    public void deleteVehicle(VehiclesDTO vehiclesDTO){
        this.vehiclesRepository.deleteById(vehiclesDTO.getId());
    }

    public Vehicles getVehicleById(long id){
        Vehicles vehicles = this.vehiclesRepository.getById(id);
        return vehicles;
    }


}
