package com.fcamara1Test.fcamara1Test.controllers;

import com.fcamara1Test.fcamara1Test.domain.Establishment;
import com.fcamara1Test.fcamara1Test.dto.establishment.EstablishmentDTO;
import com.fcamara1Test.fcamara1Test.dto.establishment.EstablishmentIdDTO;
import com.fcamara1Test.fcamara1Test.dto.establishment.EstablishmentRequestDTO;
import com.fcamara1Test.fcamara1Test.dto.establishment.EstablishmentResponseDTO;
import com.fcamara1Test.fcamara1Test.services.EstablishmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("establishment")
@RequiredArgsConstructor
public class EstablishmentController {

    private final EstablishmentService service;

    @GetMapping("/{establishmentId}")
    public ResponseEntity<EstablishmentResponseDTO> getEstablishment(@PathVariable long establishmentId){
        EstablishmentResponseDTO response = this.service.getEstablishmentDetail(establishmentId);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<EstablishmentIdDTO> createEstablishment(@RequestBody EstablishmentRequestDTO body){
        EstablishmentIdDTO establishmentIdDTO = this.service.createEstablishment(body);
        return ResponseEntity.ok(establishmentIdDTO);
    }

    @PutMapping
    public ResponseEntity updateEstablishment(@RequestBody EstablishmentDTO body){
        int response = this.service.updateEstablishment(body);
        if(response == 0){
            return ResponseEntity.ok("Estabelecimento não encontrado");
        }
        else return ResponseEntity.ok("Estabelecimento atualizado...");
    }

    @DeleteMapping
    public ResponseEntity deleteEstablishment(@RequestBody EstablishmentDTO body){
        this.service.deleteEstablishment(body);
        return ResponseEntity.ok("Estabelecimento deletado");
    }

}
