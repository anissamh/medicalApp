package com.example.medicalapp.security.services;

import com.example.medicalapp.security.entities.appRole;
import com.example.medicalapp.security.entities.appUser;
import com.example.medicalapp.security.repositories.AppRoleRepository;
import com.example.medicalapp.security.repositories.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
//permet dexecuter une transation pour mettre à jour s il y a changement à persister dans la base utilise pour addrole to user et celle de remove
@Transactional
public class ServiceAuthentication implements IServiceAuthentication{
    @Autowired
    AppUserRepository userRep;
    @Autowired
    AppRoleRepository roleRep;
    PasswordEncoder pe = new BCryptPasswordEncoder();
    @Override
    public appUser createAppUser(appUser appUser) throws  RuntimeException{
        if ((userRep.findByUsername(appUser.getUsername())!=null)){
            throw new RuntimeException("User Existe");
        }
        appUser.setPassword(pe.encode(appUser.getPassword()));
        return userRep.save(appUser);
    }



    @Override
    public appRole createAppRole(appRole appRole) throws  RuntimeException{
        if (!(roleRep.findByRolename(appRole.getRolename())==null)){
            throw new RuntimeException("role Existe");
        }
        return roleRep.save(appRole);
    }

    @Override
    public void addRoleToUser(String username, String role) {

        /* List<appRole> liste= userRep.findByUsername(username).getAppRoles() ;
         appRole ar=roleRep.findByRolename(role);
        liste.add(ar);*/
        appUser au=userRep.findByUsername(username);
        appRole ar=roleRep.findByRolename(role);
        au.getAppRoles().add(ar);
        //userRep.save(au) si il y a pas annotation transactionnel

    }

    @Override
    public void removeRoleToUser(String username, String role) {
        appUser au=userRep.findByUsername(username);
        appRole ar=roleRep.findByRolename(role);
        au.getAppRoles().remove(ar);
    }

    @Override
    public appUser LoadUserByUserName(String username) {
        return userRep.findByUsername(username);
    }
}
