package com.example.fmarca.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "establishment")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Establishment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String cnpj;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false, name = "moto_quantity")
    private int motoQuantity;

    @Column(nullable = false, name = "cars_quantity")
    private int carsQuantity;

    /*@OneToMany(mappedBy = "establishment", fetch = FetchType.LAZY, orphanRemoval = false)
    private List<Vehicles> vehiclesList = new ArrayList<>();*/

}
