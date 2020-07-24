package miniCursoSpringBancoDeDados.Excecoes;

public class UsuarioJaExiste extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UsuarioJaExiste(String msg) {
		super(msg);
	}
	public UsuarioJaExiste() {}

}
