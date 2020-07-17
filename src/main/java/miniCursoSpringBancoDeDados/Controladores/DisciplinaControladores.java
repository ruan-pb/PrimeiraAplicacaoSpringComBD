package miniCursoSpringBancoDeDados.Controladores;




import java.util.List;
import java.util.NoSuchElementException;




import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import miniCursoSpringBancoDeDados.Entidades.Disciplina;
import miniCursoSpringBancoDeDados.Excecoes.DisciplinaException;
import miniCursoSpringBancoDeDados.Servico.DisciplinaServico;

@RestController
@RequestMapping("/disciplina")
public class DisciplinaControladores {

	@Autowired
	private DisciplinaServico servico;

	

	@GetMapping("/lista")
	public List<Disciplina> lista() {
		return servico.lista();

	}
	
	@GetMapping("/{clienteId}")
	public ResponseEntity<Disciplina> buscar(@PathVariable Long clienteId) {
		try {
			
		return new ResponseEntity<Disciplina>(servico.buscar(clienteId),HttpStatus.OK);
		}
		catch(NoSuchElementException e) {

			return ResponseEntity.notFound().build();
		}
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Disciplina> receivedLike(@PathVariable Long id){ // LEMBRE QUE DESSA FORMA PODE NÃO DAR CERTO POR CONTA DESTAS LINHAS
        try {
           
            return new ResponseEntity<>(servico.DarLike(id), HttpStatus.OK);
        }catch (DisciplinaException ex){
            return new ResponseEntity<>(new Disciplina(), HttpStatus.NOT_FOUND);
        }
    }
	@PutMapping("/atualizarNota/{Id}")
	public ResponseEntity<Disciplina>AtualizarNota(@PathVariable Long Id,@RequestBody Disciplina disciplina){//olha aqui para ver se ó tipo de Double que está dando erro
		double nota = disciplina.getNota();													//modifiacar o nome da variaveis da classe controller e servico para saber qua o é a nota que o erro se refere
		try {
			return new ResponseEntity<Disciplina>(servico.atualizarNota(Id, nota),HttpStatus.OK);
		}
		catch(DisciplinaException e) {
			return ResponseEntity.notFound().build();
		}
	}
	@PutMapping("/comentarios/{Id}")
	public ResponseEntity<Disciplina> novoComentario(@PathVariable Long Id,@RequestBody Disciplina coment){
		String c = coment.getComentarios();
		try {
			return new ResponseEntity<Disciplina>(servico.AdicionarComentarios(Id, c),HttpStatus.OK);
		}
		catch(DisciplinaException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/hankingNotas")
	public List<Disciplina> hankingNotas(){
		return servico.hankingNotas();
		
	}
	@GetMapping("/hankingLikes")
	public List<Disciplina> hankingLikes(){
		return servico.hankingLikes();
	}
	
}	
