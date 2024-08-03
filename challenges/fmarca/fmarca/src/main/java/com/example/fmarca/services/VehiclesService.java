package com.example.fmarca.services;


import com.example.fmarca.domain.Vehicles;
import com.example.fmarca.dto.vehicles.VehiclesDTO;
import com.example.fmarca.dto.vehicles.VehiclesIdDTO;
import com.example.fmarca.dto.vehicles.VehiclesRequestDTO;
import com.example.fmarca.dto.vehicles.VehiclesResponseDTO;
import com.example.fmarca.repositories.VehiclesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VehiclesService {

    @Autowired
    private final VehiclesRepository vehiclesRepository;

    public VehiclesResponseDTO getVehicleDetail(Long id){
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
        vehicles.setEstablishment(vehiclesRequestDTO.getEstablishment());

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
            vehicles.setEstablishment(vehiclesDTO.getEstablishment());
            this.vehiclesRepository.save(vehicles);
            return 1;
        }
        else return 0;

    }

    public void deleteVehicle(VehiclesDTO vehiclesDTO){
        this.vehiclesRepository.deleteById(vehiclesDTO.getId());
    }

    public Vehicles getVehicleById(Long id){
        Vehicles vehicles = this.vehiclesRepository.getById(id);
        return vehicles;
    }

}
