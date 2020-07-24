package miniCursoSpringBancoDeDados.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import miniCursoSpringBancoDeDados.DTO.UsuarioLoginDTO;
import miniCursoSpringBancoDeDados.Servico.JWTService;
import miniCursoSpringBancoDeDados.Servico.LoginResponse;


@RestController
public class LoginController {
	
	@Autowired
	private JWTService jwtService;
	
	
	@PostMapping("/autorizacao/login")
	public ResponseEntity<LoginResponse> autenticarUsuario(@RequestBody UsuarioLoginDTO usuario){
		return new ResponseEntity<LoginResponse>(jwtService.autentica(usuario),HttpStatus.OK);
		
	}

}
