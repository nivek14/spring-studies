package com.example.fmarca.services;


import com.example.fmarca.domain.Establishment;
import com.example.fmarca.dto.establishment.EstablishmentDTO;
import com.example.fmarca.dto.establishment.EstablishmentIdDTO;
import com.example.fmarca.dto.establishment.EstablishmentRequestDTO;
import com.example.fmarca.dto.establishment.EstablishmentResponseDTO;
import com.example.fmarca.repositories.EstablishmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EstablishmentService {

    @Autowired
    private final EstablishmentRepository establishmentRepository;

    public EstablishmentResponseDTO getEstablishmentDetail(Long id){
        Establishment establishment = this.getEstablishmentById(id);
        return new EstablishmentResponseDTO(establishment);
    }

    public EstablishmentIdDTO createEstablishment(EstablishmentRequestDTO establishmentRequestDTO){

        Establishment establishment = new Establishment();

        establishment.setCnpj(establishmentRequestDTO.cnpj);
        establishment.setAddress(establishmentRequestDTO.address);
        establishment.setPhone(establishmentRequestDTO.phone);
        establishment.setMotoQuantity(establishmentRequestDTO.motoQuantity);
        establishment.setCarsQuantity(establishmentRequestDTO.carsQuantity);
        establishment.setMotoQuantityTotal(establishmentRequestDTO.motoQuantityTotal);
        establishment.setCarsQuantityTotal(establishmentRequestDTO.carsQuantityTotal);

        this.establishmentRepository.save(establishment);

        return new EstablishmentIdDTO(establishment.getId());

    }

    public int updateEstablishment(EstablishmentDTO establishmentDTO){
        Optional<Establishment> optional = Optional.ofNullable(this.getEstablishmentById(establishmentDTO.getId()));
        if(optional.isPresent()){
            Establishment establishment = new Establishment();
            establishment.setId(establishmentDTO.getId());
            establishment.setCnpj(establishmentDTO.getCnpj());
            establishment.setAddress(establishmentDTO.getAddress());
            establishment.setPhone(establishmentDTO.getPhone());
            establishment.setMotoQuantity(establishmentDTO.getMotoQuantity());
            establishment.setCarsQuantity(establishmentDTO.getCarsQuantity());
            establishment.setMotoQuantityTotal(establishmentDTO.getMotoQuantityTotal());
            establishment.setCarsQuantityTotal(establishmentDTO.getCarsQuantityTotal());
            this.establishmentRepository.save(establishment);
            return 1;
        }
        else return 0;
    }

    public void deleteEstablishment(EstablishmentDTO establishmentDTO){
        this.establishmentRepository.deleteById(establishmentDTO.getId());
    }

    public Establishment getEstablishmentById(Long id){
        Establishment establishment = this.establishmentRepository.findById(id).orElseThrow(() -> new RuntimeException());
        return establishment;
    }

    public int getCarSpaces(Long id){
        Establishment establishment = this.establishmentRepository.getById(id);
        return establishment.getCarsQuantityTotal();
    }

    public int getMotoSpaces(Long id){
        Establishment establishment = this.establishmentRepository.getById(id);
        return establishment.getMotoQuantityTotal();
    }

    public void updateCarSpaces(Long id, int carsSpaces){
        Establishment establishment = this.getEstablishmentById(id);
        establishment.setId(id);
        establishment.setCarsQuantity(carsSpaces);
        this.establishmentRepository.save(establishment);
    }

    public void updateMotoSpaces(Long id, int motoSpaces){
        Establishment establishment = this.getEstablishmentById(id);
        establishment.setId(id);
        establishment.setMotoQuantity(motoSpaces);
        this.establishmentRepository.save(establishment);
    }

}
