package miniCursoSpringBancoDeDados.Servico;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import miniCursoSpringBancoDeDados.DTO.UsuarioDTO;
import miniCursoSpringBancoDeDados.Entidades.Usuario;
import miniCursoSpringBancoDeDados.Excecoes.UsuarioInvalido;
import miniCursoSpringBancoDeDados.Excecoes.UsuarioJaExiste;
import miniCursoSpringBancoDeDados.Repositorio.UsuarioRepositorio;

@Service
public class UsuarioServico {
	
	
	@Autowired
	private UsuarioRepositorio<Usuario, String> usuarioDao;
	
	@Autowired
	private JWTService jwtService;
	

	public UsuarioDTO criarUsuario(Usuario usuario) {
		if(!usuario.isValid()) {
			throw new UsuarioInvalido();
			
		}
		if(usuarioDao.existsById(usuario.getEmail())) {
			throw new UsuarioJaExiste();
		}
		usuarioDao.save(usuario);
		return new UsuarioDTO(usuario);
		
	}
	
	public UsuarioDTO deletaUsuario(String cabecalho) {
		//vai ler o token e recuperar o subject
		Optional<String> usuarioId = jwtService.recuperarUsuario(cabecalho);
		
		//vai pegar o subject do token e ver se existe um usuário correspondente
		Usuario usuario = validarUsuario(usuarioId);
		
		//vai remover o usuario associado ao token
		usuarioDao.delete(usuario);
		return new UsuarioDTO(usuario);
	}
	
	
	
	
	private Usuario validarUsuario(Optional<String> id) {
		if(id.isEmpty()) {
			throw new UsuarioInvalido("error");
		}
		Optional<Usuario> usuario = usuarioDao.findByEmail(id.get());
		if(usuario.isEmpty()) {
			throw new UsuarioInvalido("error 2");
		}
		return usuario.get();
		
	}
	

}
