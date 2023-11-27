package com.example.medicalapp.service;

import com.example.medicalapp.entities.Patient;

import java.util.List;

public interface IServicePatient {
    public Patient createPatient(Patient p);
    public Patient findPatientById(int id);
    public List<Patient>findAllPatients();
    public Patient updatePatient(Patient p);
    public void deletePatient(int id);
}
