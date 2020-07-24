package miniCursoSpringBancoDeDados.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import miniCursoSpringBancoDeDados.DTO.UsuarioDTO;
import miniCursoSpringBancoDeDados.DTO.UsuarioLoginDTO;
import miniCursoSpringBancoDeDados.Entidades.Usuario;
import miniCursoSpringBancoDeDados.Excecoes.UsuarioInvalido;
import miniCursoSpringBancoDeDados.Excecoes.UsuarioJaExiste;
import miniCursoSpringBancoDeDados.Servico.UsuarioServico;


@RestController
@RequestMapping("/usuario")
public class UsuarioControlador {
	
	@Autowired
	private UsuarioServico usuarioServico;
	
	
	@PostMapping("/criarUsuario")
	public ResponseEntity<UsuarioDTO> novoUsuario(@RequestBody Usuario usuario){
		try {
			return new ResponseEntity<UsuarioDTO>(usuarioServico.criarUsuario(usuario),HttpStatus.CREATED);
		}
		catch(UsuarioJaExiste e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		catch(UsuarioInvalido e) {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
			
		}
		
	}
	@DeleteMapping("/deletar")
	public ResponseEntity<UsuarioDTO> deletar(@RequestHeader("Authorization")String token){
		
		try {
			return new ResponseEntity<UsuarioDTO>(usuarioServico.deletaUsuario(token),HttpStatus.OK);
		}
		catch(UsuarioJaExiste e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		catch(UsuarioInvalido e) {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
		
	}
	
	
	

}
