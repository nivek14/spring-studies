package com.fcamara1Test.fcamara1Test.dto.establishment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EstablishmentRequestDTO {
    public String cnpj;
    public String address;
    public String phone;
    public int motoQuantity;
    public int carsQuantity;
}
