package com.example.medicalapp.service;

import com.example.medicalapp.entities.Medecin;

import java.util.List;

public interface IServiceMedecin {
    public Medecin createMedecin(Medecin m);
    public Medecin findMedecinById(int id);
    public List<Medecin>findAllMedecins();
    public Medecin updateMedecin(Medecin m);
    public void deleteMedecin(int id);
}
