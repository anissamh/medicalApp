package com.example.medicalapp.security.repositories;

import com.example.medicalapp.security.entities.appRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<appRole,Integer> {
    appRole findByRolename(String rolename);

}
