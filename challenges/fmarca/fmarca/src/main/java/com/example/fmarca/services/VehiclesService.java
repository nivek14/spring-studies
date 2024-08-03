package com.example.fmarca.services;


import com.example.fmarca.domain.Establishment;
import com.example.fmarca.domain.Vehicles;
import com.example.fmarca.domain.VehiclesType;
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

    private final EstablishmentService establishmentService;

    private int maxCar = 0;
    private int maxMoto = 0;

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
        vehicles.setOccupying(2);
        vehicles.setType(vehiclesRequestDTO.getType());

        if (vehiclesRequestDTO.getEstablishment() == null) {
            throw new IllegalArgumentException("Establishment cannot be null");
        }

        Establishment establishment = this.establishmentService.getEstablishmentById(vehiclesRequestDTO.getEstablishment().getId());

        vehicles.setEstablishment(establishment);

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
            vehicles.setOccupying(vehiclesDTO.getOccupying());
            vehicles.setType(vehiclesDTO.getType());

            Establishment establishment = this.establishmentService.getEstablishmentById(vehiclesDTO.getEstablishment().getId());

            vehicles.setEstablishment(establishment);

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

    public String updateVehicleSpace(Long id, Integer occupied){

        Optional<Vehicles> optional = Optional.ofNullable(this.getVehicleById(id));

        if(optional.isPresent()){

            Vehicles vehicles = this.getVehicleById(id);
            Establishment establishment = this.establishmentService.getEstablishmentById(vehicles.getEstablishment().getId());

            maxCar  = this.establishmentService.getCarSpaces(vehicles.getEstablishment().getId());
            maxMoto = this.establishmentService.getMotoSpaces(vehicles.getEstablishment().getId());

            System.out.println(establishment.getCarsQuantity());

            if(vehicles.getType().equals(VehiclesType.CAR)){

                if(occupied == 1 && establishment.getCarsQuantity() != 0 && vehicles.getOccupying() != 1){

                    int aux = establishment.getCarsQuantity() - 1;

                    establishment.setCarsQuantity(aux);
                    this.establishmentService.updateCarSpaces(establishment.getId(), aux);

                    vehicles.setId(id);
                    vehicles.setOccupying(occupied);
                    vehicles.setEstablishment(establishment);

                    this.vehiclesRepository.save(vehicles);
                    return "Carro estacionado!";
                }
                else if(occupied == 0 &&
                        establishment.getCarsQuantity() < maxCar &&
                        vehicles.getOccupying() != null &&
                        vehicles.getOccupying() != 0){

                    int aux = establishment.getCarsQuantity() + 1;

                    establishment.setCarsQuantity(aux);

                    this.establishmentService.updateCarSpaces(establishment.getId(), aux);

                    vehicles.setId(id);
                    vehicles.setOccupying(occupied);
                    vehicles.setEstablishment(establishment);

                    this.vehiclesRepository.save(vehicles);

                    return "Carro deixou o estacionamento!";
                }
                else return "Houve um problema para validar a situação do estabelecimento em relação a carros.";
            }

            else if(vehicles.getType().equals(VehiclesType.MOTO)){

                if(occupied == 1 && establishment.getMotoQuantity() != 0 && vehicles.getOccupying() != 1){

                    int aux = establishment.getMotoQuantity() - 1;

                    establishment.setCarsQuantity(aux);

                    this.establishmentService.updateMotoSpaces(establishment.getId(), aux);

                    vehicles.setId(id);
                    vehicles.setOccupying(occupied);
                    vehicles.setEstablishment(establishment);

                    this.vehiclesRepository.save(vehicles);

                    return "Moto estacionado!";
                }
                else if(occupied == 0 &&
                        establishment.getMotoQuantity() < maxMoto &&
                        vehicles.getOccupying() != null &&
                        vehicles.getOccupying() != 0){

                    int aux = establishment.getMotoQuantity() + 1;

                    establishment.setCarsQuantity(aux);

                    this.establishmentService.updateMotoSpaces(establishment.getId(), aux);

                    vehicles.setId(id);
                    vehicles.setOccupying(occupied);
                    vehicles.setEstablishment(establishment);

                    this.vehiclesRepository.save(vehicles);

                    return "Moto deixou o estacionamento!";
                }
                else return "Houve um problema para validar a situação do estabelecimento em relação a Motos.";
            }

        }
        return "veiculo não encontrado";

    }

}
