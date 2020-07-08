package miniCursoSpringBancoDeDados.Controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import miniCursoSpringBancoDeDados.Entidades.Disciplina;
import miniCursoSpringBancoDeDados.Servico.DisciplinaServico;

@RestController
@RequestMapping("/disciplina")
public class DisciplinaControladores {
	
	

	
	private DisciplinaServico servico;
	
	
	
	@GetMapping
	public ResponseEntity<List<Disciplina>> lista(){
		return new ResponseEntity<List<Disciplina>>(this.servico.lista(),HttpStatus.OK);
	}
	

	
}
