package miniCursoSpringBancoDeDados.DTO;

import java.io.Serializable;

import miniCursoSpringBancoDeDados.Entidades.Disciplina;

public class DisciplinaIdNomeNota implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
    private String nome;
    private Double nota;

    public DisciplinaIdNomeNota() {}

    public DisciplinaIdNomeNota(Disciplina disciplina) {
        this.id = disciplina.getId();
        this.nome = disciplina.getNome();
        this.nota = disciplina.getNota();
    }

    public static Disciplina fromDTO(DisciplinaIdNomeNota disciplinaDTO){
        return new Disciplina(disciplinaDTO.getNome(), disciplinaDTO.getNota());
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
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
}