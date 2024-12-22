package com.example.futoverseny.service;

import com.example.futoverseny.model.Futo;
import com.example.futoverseny.model.Verseny;
import com.example.futoverseny.model.Eredmeny;
import com.example.futoverseny.repository.FutoRepository;
import com.example.futoverseny.repository.VersenyRepository;
import com.example.futoverseny.repository.EredmenyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FutoversenyService {

    @Autowired
    private FutoRepository futoRepository;

    @Autowired
    private VersenyRepository versenyRepository;

    @Autowired
    private EredmenyRepository eredmenyRepository;

    // Futók kezelése
    public List<Futo> getRunners() {
        return futoRepository.findAll();
    }

    public Futo addRunner(Futo futo) {
        if (futo.getNev() == null || futo.getNev().trim().isEmpty()) {
            throw new IllegalArgumentException("A futó neve nem lehet üres!");
        }
        return futoRepository.save(futo);
    }

    // Versenyek kezelése
    public List<Verseny> getAllRaces() {
        return versenyRepository.findAll();
    }

    public Verseny updateRace(Verseny verseny) {
        if (!versenyRepository.existsById(verseny.getId())) {
            throw new ResourceNotFoundException("Nem található verseny ezzel az ID-val: " + verseny.getId());
        }
        if (verseny.getNev() == null || verseny.getNev().trim().isEmpty()) {
            throw new IllegalArgumentException("A verseny neve nem lehet üres!");
        }
        if (verseny.getTavolsag() <= 0) {
            throw new IllegalArgumentException("A távolságnak pozitívnak kell lennie!");
        }
        return versenyRepository.save(verseny);
    }

    // Eredmények kezelése
    public List<Eredmeny> getRaceRunners(Long versenyId) {
        if (!versenyRepository.existsById(versenyId)) {
            throw new ResourceNotFoundException("Nem található verseny ezzel az ID-val: " + versenyId);
        }
        return eredmenyRepository.findAll().stream()
                .filter(e -> e.getVerseny().getId().equals(versenyId))
                .sorted(Comparator.comparing(Eredmeny::getIdoEredmeny))  // emelkedő sorrend
                .collect(Collectors.toList());
    }

    public Eredmeny addResult(Eredmeny eredmeny) {
        if (eredmeny.getFuto() == null || !futoRepository.existsById(eredmeny.getFuto().getId())) {
            throw new ResourceNotFoundException("Nem található futó!");
        }
        if (eredmeny.getVerseny() == null || !versenyRepository.existsById(eredmeny.getVerseny().getId())) {
            throw new ResourceNotFoundException("Nem található verseny!");
        }
        if (eredmeny.getIdoEredmeny() <= 0) {
            throw new IllegalArgumentException("Az időeredménynek pozitívnak kell lennie!");
        }
        return eredmenyRepository.save(eredmeny);
    }

    public double getAverageTime(Long versenyId) {
        if (!versenyRepository.existsById(versenyId)) {
            throw new ResourceNotFoundException("Nem található verseny ezzel az ID-val: " + versenyId);
        }
        List<Eredmeny> eredmenyek = getRaceRunners(versenyId);
        if (eredmenyek.isEmpty()) {
            return 0.0;
        }
        return eredmenyek.stream()
                .mapToInt(Eredmeny::getIdoEredmeny)
                .average()
                .orElse(0.0);
    }
    public Verseny createRace(Verseny verseny) {
        System.out.println("Service réteg: új verseny létrehozása"); // Debug log
        if (verseny.getNev() == null || verseny.getNev().trim().isEmpty()) {
            throw new IllegalArgumentException("A verseny neve nem lehet üres!");
        }
        if (verseny.getTavolsag() <= 0) {
            throw new IllegalArgumentException("A távolságnak pozitívnak kell lennie!");
        }
        return versenyRepository.save(verseny);
    }
}
