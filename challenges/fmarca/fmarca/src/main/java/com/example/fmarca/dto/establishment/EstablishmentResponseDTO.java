package com.example.fmarca.dto.establishment;

import com.example.fmarca.domain.Establishment;
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
                        establishment.getCarsQuantity(),
                        establishment.getMotoQuantityTotal(),
                        establishment.getCarsQuantityTotal()
                );
    }

}
