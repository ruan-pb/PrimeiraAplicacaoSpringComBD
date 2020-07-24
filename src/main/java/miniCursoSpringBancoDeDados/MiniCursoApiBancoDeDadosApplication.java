package miniCursoSpringBancoDeDados;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import miniCursoSpringBancoDeDados.filtros.filtroToken;

@SpringBootApplication
public class MiniCursoApiBancoDeDadosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiniCursoApiBancoDeDadosApplication.class, args);

	}

	@Bean
	public FilterRegistrationBean<filtroToken> filtroJwt(){
		FilterRegistrationBean<filtroToken> filtroRB = new FilterRegistrationBean<filtroToken>();
		filtroRB.setFilter(new filtroToken());
		filtroRB.addUrlPatterns("/usuario/deletar","/disciplina/*");
		return filtroRB;
		
	
	
	
	}
	}
	
