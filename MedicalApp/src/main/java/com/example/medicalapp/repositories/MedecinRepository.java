package com.example.medicalapp.repositories;

import com.example.medicalapp.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;
public interface MedecinRepository extends JpaRepository<Medecin,Integer> {
}
