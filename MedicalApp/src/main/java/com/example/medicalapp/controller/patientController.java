package com.example.medicalapp.controller;


import com.example.medicalapp.entities.Patient;
import com.example.medicalapp.service.IServicePatient;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient/")
public class patientController {
    @Autowired
    IServicePatient iServicePatient;
//final ne la valeur que je vais mettre ne changera pas

    @GetMapping("all")
    @PreAuthorize("hasAuthority('SCOPE_ROLE_user')")
    public List<Patient> listePatients(){
       // model.addAttribute("patients",iServicePatient.findAllPatients());
        //return "affichePatient";
        return iServicePatient.findAllPatients();
    }

    @GetMapping("add")
    @PreAuthorize("hasAuthority('SCOPE_ROLE_admin')")
    public Patient addPatient(Patient p){
       return iServicePatient.createPatient(p);
       // return "redirect:/patient/all";
    }

    @GetMapping("delete/{id}")
    public String deletePatient(@PathVariable int id){
        iServicePatient.deletePatient(id);
        //return "redirect:/patient/all";
        return "supprimé!";
    }

    @PostMapping("update")
    public Patient update(Patient p){
      return   iServicePatient.updatePatient(p);
       // return "redirect:/patient/all";
    }

    @GetMapping("getpatient/{id}")
public Patient getPatient(@PathVariable int id, Model model){
      return   iServicePatient.findPatientById(id);
       // return "getpatient";
    }
}


