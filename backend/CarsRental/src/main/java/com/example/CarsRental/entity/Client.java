package com.example.CarsRental.entity;

import lombok.*;

import java.util.*;
import jakarta.persistence.*;

@Entity
@Table (name="client")
public class Client extends User {
    @Getter
    @Setter
    private Date dateNaissance;
    @Getter
    @Setter
    private String cin;
    @Getter
    @Setter
    private String permisConduire;


    @OneToMany
    @JoinColumn(name="id_client")
    @Getter

    private List<Reservation> reservations = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name="favoris",
            joinColumns = @JoinColumn(name = "client_id"),
            inverseJoinColumns = @JoinColumn(name = "vehicle_id")
    )
    @Getter

    List<Vehicule> vehiculesFavorites = new ArrayList<>();


}
