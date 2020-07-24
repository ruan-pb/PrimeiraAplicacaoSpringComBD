package miniCursoSpringBancoDeDados.DTO;

import miniCursoSpringBancoDeDados.Entidades.Usuario;

public class UsuarioDTO {
	
	private String email;
	private String nome;
	
	public UsuarioDTO(Usuario usu) {
		this.email = usu.getEmail();
		this.nome = usu.getNome();
	}
	public UsuarioDTO() {}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	

}
