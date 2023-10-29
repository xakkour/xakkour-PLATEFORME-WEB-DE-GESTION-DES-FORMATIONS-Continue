package com.pfe.myschool;

import com.pfe.myschool.model.User;
import com.pfe.myschool.repository.UserRepository;
import com.pfe.myschool.service.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StartApplication {

	public static void main(String[] args) {
		SpringApplication.run(StartApplication.class, args);
	}



CommandLineRunner commandLineRunner (AccountService accountService){

		return args -> {



			accountService.addNewUser("user1","123456789",
					"chakkour@gmail.com","123456789","ADMIN");


		};
}
}

