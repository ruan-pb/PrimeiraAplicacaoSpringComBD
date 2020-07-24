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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import miniCursoSpringBancoDeDados.DTO.DisciplinaIdNomeComentario;
import miniCursoSpringBancoDeDados.DTO.DisciplinaIdNomeLikes;
import miniCursoSpringBancoDeDados.DTO.DisciplinaIdNomeNota;
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
	public ResponseEntity<List<DisciplinaIdNomeNota>> lista() {
		return new ResponseEntity<>(servicos.lista(),HttpStatus.OK);

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
	public ResponseEntity<DisciplinaIdNomeLikes> receberLike(@PathVariable Long id){
        try {
            Disciplina disciplina = servicos.DarLike(id);
            return new ResponseEntity<>(new DisciplinaIdNomeLikes(disciplina), HttpStatus.OK);
            
        }catch (DisciplinaException ex){
            return ResponseEntity.notFound().build();
        }
    }
	@PutMapping("/atualizarNota/{Id}")
	public ResponseEntity<DisciplinaIdNomeNota>AtualizacaoDeNota(@PathVariable Long Id,@RequestBody Disciplina disciplina){
		double nota = disciplina.getNota();
		Disciplina disciplina01 = servicos.atualizarNota(Id, nota);
		try {
			return new ResponseEntity<DisciplinaIdNomeNota>(new DisciplinaIdNomeNota(disciplina01),HttpStatus.OK);
		}
		catch(DisciplinaException e) {
			return ResponseEntity.notFound().build();
		}
	}
	@PutMapping("/comentarios/{Id}")
	public ResponseEntity<DisciplinaIdNomeComentario> novoComentario(@PathVariable Long Id,@RequestBody Disciplina coment) throws IOException{
		String c = coment.getComentarios();
		Disciplina disciplina01= servicos.AdicionarComentarios(Id, c);
		try {
			return new ResponseEntity<DisciplinaIdNomeComentario>(new DisciplinaIdNomeComentario(disciplina01),HttpStatus.OK);
		}
		catch(DisciplinaException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/hankingNotas")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<DisciplinaIdNomeNota>> hankingNotas(){
		return new ResponseEntity<>(servicos.hankingNotas(),HttpStatus.OK);
		
	}
	@GetMapping("/hankingLikes")
	public ResponseEntity<List<DisciplinaIdNomeLikes>> hankingLikes(){
		return new ResponseEntity<>(servicos.hankingLikes(),HttpStatus.OK);
	}
	
}	
