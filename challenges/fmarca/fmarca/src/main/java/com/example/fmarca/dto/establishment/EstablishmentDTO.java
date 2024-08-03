package com.example.fmarca.dto.establishment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EstablishmentDTO {
    private long id;
    private String cnpj;
    private String address;
    private String phone;
    private int motoQuantity;
    private int carsQuantity;
    private int motoQuantityTotal;
    private int carsQuantityTotal;
}
