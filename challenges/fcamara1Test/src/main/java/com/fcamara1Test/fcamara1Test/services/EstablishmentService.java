package com.fcamara1Test.fcamara1Test.services;

import com.fcamara1Test.fcamara1Test.domain.Establishment;
import com.fcamara1Test.fcamara1Test.dto.establishment.EstablishmentDTO;
import com.fcamara1Test.fcamara1Test.dto.establishment.EstablishmentIdDTO;
import com.fcamara1Test.fcamara1Test.dto.establishment.EstablishmentRequestDTO;
import com.fcamara1Test.fcamara1Test.dto.establishment.EstablishmentResponseDTO;
import com.fcamara1Test.fcamara1Test.repositories.EstablishmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EstablishmentService {

    private final EstablishmentRepository establishmentRepository;

    public EstablishmentResponseDTO getEstablishmentDetail(long id){
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
            this.establishmentRepository.save(establishment);
            return 1;
        }
        else return 0;
    }

    public void deleteEstablishment(EstablishmentDTO establishmentDTO){
        this.establishmentRepository.deleteById(establishmentDTO.getId());
    }

    // TODO: Implementar exceção para caso não exista o id
    public Establishment getEstablishmentById(long id){
        Establishment establishment = this.establishmentRepository.findById(id).orElseThrow(() -> new RuntimeException());
        return establishment;
    }

}
