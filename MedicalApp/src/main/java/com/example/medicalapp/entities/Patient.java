package com.example.medicalapp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Patient {
    // nouveaute toutes les annotations de persisitances etaent da javax sont devenus jakarta
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private  int id;
    private String nom;
    private String prenom;
    private  String ville;
    private String telephone;
}
