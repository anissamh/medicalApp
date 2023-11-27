package com.example.medicalapp.security.services;

import com.example.medicalapp.security.entities.appRole;
import com.example.medicalapp.security.entities.appUser;

public interface IServiceAuthentication {
    public appUser createAppUser(appUser appUser);
    public appRole createAppRole(appRole appRole);
    public void addRoleToUser(String username, String role);
    public void removeRoleToUser(String username, String role);
    public appUser LoadUserByUserName(String username);
}
