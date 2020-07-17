package miniCursoSpringBancoDeDados.Entidades;



import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Disciplina {
	
	@Id
	@GeneratedValue
	private Long id;
	
	public String nome;
	@Basic(optional = false)
    @Column(nullable = false)
	private double nota;
	private String comentarios;
	
	@Basic(optional = false)
    @Column(nullable = false)
	private int likes;
	
	
	public Disciplina() {
		
	}
	public Disciplina(String nome, double nota) {
        this.nome = nome;
        this.nota = nota;
    }

    public Disciplina(String nome, double nota, int likes, String comment) {
        this(nome, nota);
        this.likes = likes;
        this.comentarios = comment;
    }
	
	public Disciplina(Long id, String nome, double nota, String comentarios, int likes) {
		super();
		this.id = id;
		this.nome = nome;
		this.nota = nota;
		this.comentarios = comentarios;
		this.likes =likes;
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


	public int getLikes() {
		return likes;
	}


	public void setLikes(int likes) {
		this.likes = likes;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ID "+this.id);
		
		sb.append("Nome "+nome);
		sb.append("Nota "+String.format("%.2f", this.nota));
		sb.append("Comentarios ");
		sb.append(this.comentarios);
		sb.append("likes ");
		sb.append(this.likes);
		return sb.toString();
	}
	

	
	

}
