package com.ABCD.ControleAbastecimento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class ControleAbastecimentoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControleAbastecimentoApplication.class, args);
	}

}
