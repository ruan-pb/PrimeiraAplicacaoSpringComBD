package miniCursoSpringBancoDeDados.Servico;

import java.io.IOException;

import java.io.InputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import miniCursoSpringBancoDeDados.Entidades.Disciplina;
import miniCursoSpringBancoDeDados.Excecoes.DisciplinaException;
import miniCursoSpringBancoDeDados.Repositorio.DisciplinaRepositorio;

@Service
public class DisciplinaServico {

	@Autowired
	private DisciplinaRepositorio<Disciplina, Long> disciplinaBD;

	public DisciplinaServico() {

	}

	@PostConstruct
	public void initDisciplinas() {

		try {
			if (disciplinaBD.count() == 96L) {
				System.out.println("Já existe 96 elementos");

			} else {

				ObjectMapper mapper = new ObjectMapper();
				TypeReference<List<Disciplina>> tipoDeDados = new TypeReference<List<Disciplina>>() {
				};
				InputStream inputStream = ObjectMapper.class.getResourceAsStream("/json/disciplina.json");
				List<Disciplina> disciplina = mapper.readValue(inputStream, tipoDeDados);

				System.out.println(this.lista());
				System.out.println("Disciplinas salva no Banco De Dados");
				this.disciplinaBD.saveAll(disciplina);
			}
		} catch (IOException e) {
			System.out.println("não foi possivel salvar " + e.getMessage());

		}

	}

	public List<Disciplina> lista() {
		return this.disciplinaBD.findAll();
	}

	public Disciplina buscar(Long clienteId) {
		Optional<Disciplina> cliente = disciplinaBD.findById(clienteId);
		if (cliente.isPresent()) {
			return cliente.get();
		}

		return null;
	}

	public Disciplina getOne(Long id) throws DisciplinaException {
		Optional<Disciplina> disciplina = this.disciplinaBD.findById(id);
		if (disciplina != null)
			return disciplina.get();
		throw new DisciplinaException("Disciplina não encontrada");
	}

	public Disciplina DarLike(Long id) throws DisciplinaException {
		Optional<Disciplina> dis = this.disciplinaBD.findById(id);
		Disciplina disciplina = null;
		if (dis != null){
			disciplina = dis.get();
			disciplina.setLikes(disciplina.getLikes() + 1);
			this.disciplinaBD.save(disciplina);
			return disciplina;
		}
		else {
			throw new DisciplinaException("Discipliina Não Encontrada");
		}
		

	}

	public Disciplina atualizarNota(Long id, double novaNota) {
		Disciplina disciplina01 = this.getOne(id);
		
		if (disciplina01.getId() == id) {
			
			if (disciplina01.getNota() == 0.0) {
				disciplina01.setNota(novaNota);
				disciplinaBD.save(disciplina01);
				
			} else {
				disciplina01.setNota((disciplina01.getNota() + novaNota) / 2);
				disciplinaBD.save(disciplina01);

			}
		}
		return disciplina01;
	}

	public Disciplina AdicionarComentarios(Long id, String novoComentario) {
		Disciplina comentarios = this.getOne(id);

		if (comentarios.getComentarios() == null) {
			comentarios.setComentarios(novoComentario);
			disciplinaBD.save(comentarios);
		} else {
			String com = comentarios.getComentarios() + "---";
			String masCom = com + novoComentario;
			comentarios.setComentarios(masCom);
			disciplinaBD.save(comentarios);
		}
		return comentarios;
	}
	
	public List<Disciplina> hankingNotas(){
		return this.disciplinaBD.findByOrderByNotaDesc();
	}
	public List<Disciplina> hankingLikes(){
		return this.disciplinaBD.findByOrderByLikesDesc();
	}

}
