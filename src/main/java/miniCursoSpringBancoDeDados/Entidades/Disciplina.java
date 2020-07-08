package miniCursoSpringBancoDeDados.Entidades;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;



@Entity
@AllArgsConstructor
public class Disciplina {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	public String nome;
	private Double nota;
	private String comentarios;
	private Integer likes;
	
	
	public Disciplina() {
		
	}
	public Disciplina(@JsonProperty("nome") String nome) {
		this.nome = nome;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Double getNota() {
		return nota;
	}


	public void setNota(Double nota) {
		this.nota = nota;
	}


	public String getComentarios() {
		return comentarios;
	}


	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}


	public Integer getLikes() {
		return likes;
	}


	public void setLikes(Integer likes) {
		this.likes = likes;
	}
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ID "+this.id+" \n");
		sb.append("Nome"+nome+"\n");
		sb.append("Nota "+this.nota+"\n");
		sb.append("Comentarios"+"\n");
		sb.append(comentarios);
		sb.append("likes ");
		sb.append(this.likes);
		return sb.toString();
	}
	

	
	

}
