package com.fcamara1Test.fcamara1Test.controllers;

import com.fcamara1Test.fcamara1Test.dto.vehicles.VehiclesDTO;
import com.fcamara1Test.fcamara1Test.dto.vehicles.VehiclesIdDTO;
import com.fcamara1Test.fcamara1Test.dto.vehicles.VehiclesRequestDTO;
import com.fcamara1Test.fcamara1Test.dto.vehicles.VehiclesResponseDTO;
import com.fcamara1Test.fcamara1Test.services.VehiclesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("vehicle")
@RequiredArgsConstructor
public class VehiclesController {

    private final VehiclesService service;

    @GetMapping("/{vehicleId}")
    public ResponseEntity<VehiclesResponseDTO> getEstablishment(@PathVariable long vehicleId){
        VehiclesResponseDTO response = this.service.getVehicleDetail(vehicleId);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<VehiclesIdDTO> createEstablishment(@RequestBody VehiclesRequestDTO body){
        VehiclesIdDTO vehiclesIdDTO = this.service.createVehicle(body);
        return ResponseEntity.ok(vehiclesIdDTO);
    }

    @PutMapping
    public ResponseEntity updateEstablishment(@RequestBody VehiclesDTO body){
        int response = this.service.updateVehicle(body);
        if(response == 0){
            return ResponseEntity.ok("Estabelecimento não encontrado");
        }
        else return ResponseEntity.ok("Estabelecimento atualizado...");
    }

    @DeleteMapping
    public ResponseEntity deleteEstablishment(@RequestBody VehiclesDTO body){
        this.service.deleteVehicle(body);
        return ResponseEntity.ok("Estabelecimento deletado");
    }

}
