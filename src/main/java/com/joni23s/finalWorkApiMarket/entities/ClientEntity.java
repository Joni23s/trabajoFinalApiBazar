package com.joni23s.finalWorkApiMarket.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "clients")
@Getter @Setter
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_client")
    private Long idClient;

    private String name;

    private String lastName;

    private int dni;

    public ClientEntity() { }

    public ClientEntity(Long idClient) {
        this.idClient = idClient;
    }

    public ClientEntity(Long idClient, String name, String lastName, int dni) {
        this.idClient = idClient;
        this.name = name;
        this.lastName = lastName;
        this.dni = dni;
    }
}
