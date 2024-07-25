package com.example.fmarca.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "vehicles")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Vehicles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String brand;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private String color;

    @Column(nullable = false)
    private String plate;

    @Enumerated(EnumType.STRING)
    private VehiclesType type;

    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "establishment.cnpj")
    private Establishment establishment;*/

}
