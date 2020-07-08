package miniCursoSpringBancoDeDados.Servico;

import java.io.IOException;

import java.io.InputStream;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import miniCursoSpringBancoDeDados.Entidades.Disciplina;
import miniCursoSpringBancoDeDados.Repositorio.DisciplinaRepositorio;

@Service
public class DisciplinaServico {

	@Autowired
	private DisciplinaRepositorio<Disciplina, Long> disciplinaBD;

	public DisciplinaServico() {

	}

	@PostConstruct
	public void initDisciplinas() {

		ObjectMapper mapper = new ObjectMapper();
		TypeReference<List<Disciplina>> tipoDeDados = new TypeReference<List<Disciplina>>() {
		};
		InputStream inputStream = ObjectMapper.class.getResourceAsStream("/json/disciplina.json");

		try {

			List<Disciplina> disciplina = mapper.readValue(inputStream, tipoDeDados);

			this.disciplinaBD.saveAll(disciplina);
			System.out.println("Disciplinas salva no Banco De Dados");

		} catch (IOException e) {
			System.out.println("não foi possivel salvar " + e.getMessage());

		}

	}

	public List<Disciplina> lista() {
		return this.disciplinaBD.findAll();
	}

}
