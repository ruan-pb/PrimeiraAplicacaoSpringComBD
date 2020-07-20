package miniCursoSpringBancoDeDados.DTO;

import miniCursoSpringBancoDeDados.Entidades.Disciplina;

public class DisciplinaIdNomeLikes {
	
	private Long Id;
	private String Nome;
	private int likes;
	
	
	public DisciplinaIdNomeLikes(Disciplina c) {
		this.Id = c.getId();
		this.Nome = c.getNome();
		this.likes = c.getLikes();
	}
	public DisciplinaIdNomeLikes() {
		
	}
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	
	
	

}
