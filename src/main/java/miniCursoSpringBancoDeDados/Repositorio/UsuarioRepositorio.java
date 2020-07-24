package miniCursoSpringBancoDeDados.Repositorio;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import miniCursoSpringBancoDeDados.Entidades.Usuario;


@Repository
public interface UsuarioRepositorio<T,Id extends Serializable> extends JpaRepository<Usuario, String> {
	
	Optional<Usuario>findByEmail(String email);

}
