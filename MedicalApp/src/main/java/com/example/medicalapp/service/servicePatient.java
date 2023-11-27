package com.example.medicalapp.service;

import com.example.medicalapp.entities.Patient;
import com.example.medicalapp.repositories.MedecinRepository;
import com.example.medicalapp.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class servicePatient implements IServicePatient {
@Autowired
   PatientRepository pp;
    @Override
    public Patient createPatient(Patient p) {
        return pp.save(p);
    }

    @Override
    public Patient findPatientById(int id) {
        return pp.findById(id).get();
    }

    @Override
    public List<Patient> findAllPatients() {
        return pp.findAll();
    }

    @Override
    public Patient updatePatient(Patient p) {
        return pp.save(p);
    }

    @Override
    public void deletePatient(int id) {
        pp.deleteById(id);

    }
}
