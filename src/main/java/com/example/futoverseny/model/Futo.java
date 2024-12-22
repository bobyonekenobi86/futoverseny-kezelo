package com.example.futoverseny.model;

import jakarta.persistence.*;


@Entity
@Table(name = "futo")
public class Futo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nev;

    private int eletkor;

    @Column(nullable = false)
    private String nem;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public int getEletkor() {
        return eletkor;
    }

    public void setEletkor(int eletkor) {
        this.eletkor = eletkor;
    }

    public String getNem() {
        return nem;
    }

    public void setNem(String nem) {
        this.nem = nem;
    }

    // Default konstruktor
    public Futo() {}

    // Konstruktor
    public Futo(String nev, int eletkor, String nem) {
        this.nev = nev;
        this.eletkor = eletkor;
        this.nem = nem;
    }


}
