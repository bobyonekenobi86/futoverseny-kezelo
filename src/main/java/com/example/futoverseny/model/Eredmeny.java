package com.example.futoverseny.model;

import jakarta.persistence.*;


@Entity
@Table(name = "eredmeny")
public class Eredmeny {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "futo_id", nullable = false)
    private Futo futo;

    public void setId(Long id) {
        this.id = id;
    }

    public void setFuto(Futo futo) {
        this.futo = futo;
    }

    public void setVerseny(Verseny verseny) {
        this.verseny = verseny;
    }

    public void setIdoEredmeny(int idoEredmeny) {
        this.idoEredmeny = idoEredmeny;
    }

    public Long getId() {
        return id;
    }

    public Futo getFuto() {
        return futo;
    }

    public Verseny getVerseny() {
        return verseny;
    }

    public int getIdoEredmeny() {
        return idoEredmeny;
    }

    @ManyToOne
    @JoinColumn(name = "verseny_id", nullable = false)
    private Verseny verseny;

    @Column(nullable = false)
    private int idoEredmeny;

    // Default konstruktor
    public Eredmeny() {}

    // Konstruktor
    public Eredmeny(Futo futo, Verseny verseny, int idoEredmeny) {
        this.futo = futo;
        this.verseny = verseny;
        this.idoEredmeny = idoEredmeny;
    }

}
