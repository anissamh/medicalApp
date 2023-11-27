package com.example.medicalapp.security.services;

import com.example.medicalapp.security.entities.appUser;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService{
    private final IServiceAuthentication iServiceAuthentication;
   // @Autowired UserDetailsServiceImpl userDetService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       appUser appUser=iServiceAuthentication.LoadUserByUserName(username);
       if(appUser==null)throw  new UsernameNotFoundException("User with"+username+"does not exist");
       String[] roles=appUser.getAppRoles().stream().map(u->u.getRolename()).toArray(String[]::new);

        return User
                .withUsername(appUser.getUsername())
                .password(appUser.getPassword())
                .roles(roles)
                .build();
    }
}
