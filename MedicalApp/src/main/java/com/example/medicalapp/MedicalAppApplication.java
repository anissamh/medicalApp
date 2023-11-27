package com.example.medicalapp;

import com.example.medicalapp.security.entities.appRole;
import com.example.medicalapp.security.entities.appUser;
import com.example.medicalapp.security.services.IServiceAuthentication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MedicalAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedicalAppApplication.class, args);
	}


/*	@Bean
	CommandLineRunner commandLineRunner(IServiceAuthentication iServiceAuthentication){
		return  args -> {
			iServiceAuthentication.createAppRole(new appRole(1,"user",null));
			iServiceAuthentication.createAppRole(new appRole(2,"admin",null));
			iServiceAuthentication.createAppUser(new appUser(1,"user1","12345","am@gmail.com",null));
			iServiceAuthentication.createAppUser(new appUser(2,"admin","admin","am@gmail.com",null));
			iServiceAuthentication.addRoleToUser("user1","user");
			iServiceAuthentication.addRoleToUser("admin","user");
			iServiceAuthentication.addRoleToUser("admin","admin");





		};
	}*/
}