package com.example.CarsRental.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Client extends User {

    private Date dateNaissance;
    private String cin;
    private String permisConduire;

    /*@OneToMany
    @JoinColumn(name="id_client")
    private List<Reservation> reservations = new ArrayList<>();*/

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getPermisConduire() {
        return permisConduire;
    }

    public void setPermisConduire(String permisConduire) {
        this.permisConduire = permisConduire;
    }
}
