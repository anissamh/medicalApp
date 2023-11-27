package com.example.medicalapp.security.repositories;

import com.example.medicalapp.security.entities.appUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<appUser,Integer> {
    appUser findByUsername(String username);

}
