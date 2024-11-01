package br.com.sistemadecorrida;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;



@OpenAPIDefinition(
		info = @Info(
				title = "Sistema de Corrida",
				version = "1.0",
				description = "O sistema de corrida permite a gestão de eventos, participantes e suporte, abrangendo informações sobre corridas, espectadores, equipes, treinadores (coaches) e patrocinadores, integrando a organização, visualização e acompanhamento de competições."


		)
)



@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

}
