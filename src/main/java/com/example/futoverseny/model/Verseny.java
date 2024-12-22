package com.example.futoverseny.model;

import jakarta.persistence.*;

@Entity
@Table(name = "verseny")
public class Verseny {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nev;

    @Column(nullable = false)
    private double tavolsag;

    // Default konstruktor
    public Verseny() {}

    // Getterek és setterek
    public Long getId() {
        return id;
    }
    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public double getTavolsag() {
        return tavolsag;
    }

    public void setTavolsag(double tavolsag) {
        this.tavolsag = tavolsag;
    }
}
