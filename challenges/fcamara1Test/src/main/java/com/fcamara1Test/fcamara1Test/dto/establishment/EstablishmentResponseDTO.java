package com.fcamara1Test.fcamara1Test.dto.establishment;

import com.fcamara1Test.fcamara1Test.domain.Establishment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EstablishmentResponseDTO {

    private EstablishmentDTO establishmentDTO;

    public EstablishmentResponseDTO(Establishment establishment){
        this.establishmentDTO =
                new EstablishmentDTO(
                        establishment.getId(),
                        establishment.getCnpj(),
                        establishment.getAddress(),
                        establishment.getPhone(),
                        establishment.getMotoQuantity(),
                        establishment.getCarsQuantity()
                );
    }

}
