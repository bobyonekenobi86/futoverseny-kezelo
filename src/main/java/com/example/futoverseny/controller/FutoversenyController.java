package com.example.futoverseny.controller;

import com.example.futoverseny.model.Futo;
import com.example.futoverseny.model.Verseny;
import com.example.futoverseny.model.Eredmeny;
import com.example.futoverseny.service.FutoversenyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FutoversenyController {

    @Autowired
    private FutoversenyService futoversenyService;

    // Futók kezelése
    @GetMapping("/getRunners")
    public List<Futo> getRunners() {
        return futoversenyService.getRunners();
    }

    @PostMapping("/addRunner")
    public Futo addRunner(@RequestBody Futo futo) {
        return futoversenyService.addRunner(futo);
    }

    // Versenyek kezelése
    @GetMapping("/getRaceRunners/{id}")
    public List<Eredmeny> getRaceRunners(@PathVariable Long id) {
        return futoversenyService.getRaceRunners(id);
    }

    @PostMapping("/updateRace")
    public Verseny updateRace(@RequestBody Verseny verseny) {
        return futoversenyService.updateRace(verseny);
    }

    // Eredmények kezelése
    @PostMapping("/addResult")
    public Eredmeny addResult(@RequestBody Eredmeny eredmeny) {
        return futoversenyService.addResult(eredmeny);
    }

    @GetMapping("/getAverageTime/{versenyId}")
    public double getAverageTime(@PathVariable Long versenyId) {
        return futoversenyService.getAverageTime(versenyId);
    }
}
