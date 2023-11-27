package com.example.medicalapp.controller;

import com.example.medicalapp.entities.Medecin;
import com.example.medicalapp.entities.Patient;
import com.example.medicalapp.service.IServiceMedecin;
import com.example.medicalapp.service.IServicePatient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medecin/")
public class medecinController {
    @Autowired
    IServiceMedecin iServiceMedecin;


    @GetMapping("all")
    public List<Medecin> listeMedecin(Model model){
      //  model.addAttribute("medecins",iServiceMedecin.findAllMedecins());
      //  return "afficheMedecin";
        return iServiceMedecin.findAllMedecins();
    }
    @GetMapping
    public  Medecin getMedecinParId(@PathVariable int id, Model model){
        return iServiceMedecin.findMedecinById(id);
    }

    @PostMapping("add")
    @PreAuthorize("hasAuthority('SCOPE_ROLE_admin')")
    public Medecin addMedecin(Medecin m){
        return iServiceMedecin.createMedecin(m);
        //return "redirect:/patient/all";
    }

    @GetMapping("delete/{id}")
    @PreAuthorize("hasAuthority('SCOPE_ROLE_admin')")
    public String deleteMedecin(@PathVariable int id){
        iServiceMedecin.deleteMedecin(id);
       // return "redirect:/medecin/all";
        return "supprimé! ";
    }

    @PostMapping("update")
    @PreAuthorize("hasAuthority('SCOPE_ROLE_admin')")
    public Medecin update(Medecin m){
       return iServiceMedecin.updateMedecin(m);
       // return "redirect:/medecin/all";
    }

    @GetMapping("getmedecin/{id}")
    @PreAuthorize("hasAuthority('SCOPE_ROLE_admin')")
    public Medecin getMedecin(@PathVariable int id, Model model){
        return iServiceMedecin.findMedecinById(id);
        //return "getmedecin";
    }
}
