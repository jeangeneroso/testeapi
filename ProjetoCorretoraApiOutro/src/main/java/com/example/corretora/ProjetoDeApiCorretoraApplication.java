package com.example.corretora;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.example.corretora"})
public class ProjetoDeApiCorretoraApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoDeApiCorretoraApplication.class, args);
	}

}
