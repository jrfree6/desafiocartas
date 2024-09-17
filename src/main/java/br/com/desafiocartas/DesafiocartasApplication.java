package br.com.desafiocartas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DesafiocartasApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafiocartasApplication.class, args);
	}

}
