package miniCursoSpringBancoDeDados.Repositorio;

import java.io.Serializable;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import miniCursoSpringBancoDeDados.Entidades.Disciplina;


@Repository
public interface DisciplinaRepositorio<T,ID extends Serializable> extends JpaRepository<Disciplina, Long>{

}
