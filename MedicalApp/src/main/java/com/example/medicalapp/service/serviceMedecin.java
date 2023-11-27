package com.example.medicalapp.service;


import com.example.medicalapp.entities.Medecin;
import com.example.medicalapp.repositories.MedecinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class serviceMedecin implements IServiceMedecin {
    @Autowired
    MedecinRepository mr;
    @Override
    public Medecin createMedecin(Medecin m) {
        return mr.save(m);
    }

    @Override
    public Medecin findMedecinById(int id) {
        return mr.findById(id).get();
    }

    @Override
    public List<Medecin> findAllMedecins() {
        return mr.findAll();
    }

    @Override
    public Medecin updateMedecin(Medecin m) {
        return mr.save(m);
    }

    @Override
    public void deleteMedecin(int id) {
        mr.deleteById(id);
    }
}
