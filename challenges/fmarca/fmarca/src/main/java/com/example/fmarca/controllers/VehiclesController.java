package com.example.fmarca.controllers;


import com.example.fmarca.dto.vehicles.VehiclesDTO;
import com.example.fmarca.dto.vehicles.VehiclesIdDTO;
import com.example.fmarca.dto.vehicles.VehiclesRequestDTO;
import com.example.fmarca.dto.vehicles.VehiclesResponseDTO;
import com.example.fmarca.services.VehiclesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehicle")
@RequiredArgsConstructor
public class VehiclesController {

    private final VehiclesService service;

    @GetMapping("/{vehicleId}")
    public ResponseEntity<VehiclesResponseDTO> getVehicles(@PathVariable Long vehicleId){
        VehiclesResponseDTO response = this.service.getVehicleDetail(vehicleId);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<VehiclesIdDTO> createVehicles(@RequestBody VehiclesRequestDTO body){
        VehiclesIdDTO vehiclesIdDTO = this.service.createVehicle(body);
        return ResponseEntity.ok(vehiclesIdDTO);
    }

    @PutMapping
    public ResponseEntity updateVehicles(@RequestBody VehiclesDTO body){
        int response = this.service.updateVehicle(body);
        if(response == 0){
            return ResponseEntity.ok("veiculo não encontrado");
        }
        else return ResponseEntity.ok("veiculo atualizado...");
    }

    @PutMapping("/{vehicleId}/{occupaied}")
    public ResponseEntity updateVehiclesSpace(@PathVariable Long vehicleId, @PathVariable Integer occupaied){
        int response = this.service.updateVehicleSpace(vehicleId, occupaied);
        if(response == 0){
            return ResponseEntity.ok("veiculo não encontrado");
        }
        else return ResponseEntity.ok("veiculo atualizado...");
    }

    @DeleteMapping
    public ResponseEntity deleteVehicles(@RequestBody VehiclesDTO body){
        this.service.deleteVehicle(body);
        return ResponseEntity.ok("Veiculo deletado");
    }

}
