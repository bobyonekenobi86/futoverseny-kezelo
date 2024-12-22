package com.example.futoverseny.controller;

import com.example.futoverseny.model.Verseny;
import com.example.futoverseny.model.Eredmeny;
import com.example.futoverseny.service.FutoversenyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class WebController {

    @Autowired
    private FutoversenyService futoversenyService;

    @GetMapping("/")
    public String listVersenyek(Model model) {
        model.addAttribute("versenyek", futoversenyService.getAllRaces());
        model.addAttribute("verseny", new Verseny());
        return "versenyek";
    }

    @GetMapping("/verseny/{id}")
    public String versenyReszletek(@PathVariable Long id, Model model) {
        try {
            List<Eredmeny> eredmenyek = futoversenyService.getRaceRunners(id);
            model.addAttribute("eredmenyek", eredmenyek);
            return "verseny-reszletek";
        } catch (Exception e) {
            return "redirect:/";
        }
    }

    @PostMapping("/verseny/uj")
    public String ujVerseny(@ModelAttribute("verseny") Verseny verseny) {
        System.out.println("Beérkezett verseny adatok: " + verseny.getNev() + ", " + verseny.getTavolsag());
        try {
            futoversenyService.createRace(verseny);
        } catch (Exception e) {
            System.out.println("Hiba történt: " + e.getMessage());
        }
        return "redirect:/";
    }
}
