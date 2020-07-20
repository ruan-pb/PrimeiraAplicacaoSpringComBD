package miniCursoSpringBancoDeDados.DTO;

import miniCursoSpringBancoDeDados.Entidades.Disciplina;

public class DisciplinaIdNomeComentario {
	private Long Id;
	private String nome;
	private String comentario;
	public DisciplinaIdNomeComentario(Disciplina c) {
		super();
		Id = c.getId();
		this.nome = c.getNome();
		this.comentario = c.getComentarios();
	}
	public DisciplinaIdNomeComentario() {
		
	}
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	
	

}
