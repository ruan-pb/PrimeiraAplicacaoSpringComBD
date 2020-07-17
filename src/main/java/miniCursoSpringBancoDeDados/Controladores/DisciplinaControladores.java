package miniCursoSpringBancoDeDados.Controladores;




import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import miniCursoSpringBancoDeDados.Entidades.Disciplina;
import miniCursoSpringBancoDeDados.Excecoes.DisciplinaException;
import miniCursoSpringBancoDeDados.Servico.DisciplinaServico;

@RestController
@RequestMapping("/disciplina")
public class DisciplinaControladores {

	@Autowired
	private DisciplinaServico servicos;

	

	@GetMapping("/lista")
	@ResponseStatus(HttpStatus.OK)
	public List<Disciplina> lista() {
		return servicos.lista();

	}
	
	@GetMapping("/{Id}")
	public ResponseEntity<Disciplina> buscar(@PathVariable Long Id) {
		try {
			
		return new ResponseEntity<Disciplina>(servicos.buscar(Id),HttpStatus.OK);
		}
		catch(DisciplinaException e) {

			return ResponseEntity.notFound().build();
		}
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Disciplina> receberLike(@PathVariable Long id){
        try {
           
            return new ResponseEntity<>(servicos.DarLike(id), HttpStatus.OK);
            
        }catch (DisciplinaException ex){
            return ResponseEntity.notFound().build();
        }
    }
	@PutMapping("/atualizarNota/{Id}")
	public ResponseEntity<Disciplina>AtualizacaoDeNota(@PathVariable Long Id,@RequestBody Disciplina disciplina){
		double nota = disciplina.getNota();													
		try {
			return new ResponseEntity<Disciplina>(servicos.atualizarNota(Id, nota),HttpStatus.OK);
		}
		catch(DisciplinaException e) {
			return ResponseEntity.notFound().build();
		}
	}
	@PutMapping("/comentarios/{Id}")
	public ResponseEntity<Disciplina> novoComentario(@PathVariable Long Id,@RequestBody Disciplina coment) throws IOException{
		String c = coment.getComentarios();
		try {
			return new ResponseEntity<Disciplina>(servicos.AdicionarComentarios(Id, c),HttpStatus.OK);
		}
		catch(DisciplinaException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/hankingNotas")
	@ResponseStatus(HttpStatus.OK)
	public List<Disciplina> hankingNotas(){
		return servicos.hankingNotas();
		
	}
	@GetMapping("/hankingLikes")
	@ResponseStatus(HttpStatus.OK)
	public List<Disciplina> hankingLikes(){
		return servicos.hankingLikes();
	}
	
}	
