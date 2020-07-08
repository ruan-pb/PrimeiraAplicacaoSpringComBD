package miniCursoSpringBancoDeDados;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import miniCursoSpringBancoDeDados.Entidades.Disciplina;
import miniCursoSpringBancoDeDados.Servico.DisciplinaServico;

@SpringBootApplication
public class MiniCursoApiBancoDeDadosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiniCursoApiBancoDeDadosApplication.class, args);
	}
	
	/*
	@Bean
	CommandLineRunner runner(DisciplinaServico userService){
	    return args -> {
			// read JSON and load json
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<Disciplina>> typeReference = new TypeReference<List<Disciplina>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/disciplina.json");
			try {
				List<Disciplina> users = mapper.readValue(inputStream,typeReference);
				userService.save(users);
				System.out.println("Users Saved!");
			} catch (IOException e){
				System.out.println("Unable to save users: " + e.getMessage());
			}
	    };
	    
	    */
	}


