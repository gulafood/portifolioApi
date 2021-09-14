package br.com.gulafood.exception;

public class UsuarioExceptionMensagemErro extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public UsuarioExceptionMensagemErro(String mensagem) {
		super(mensagem);
	}
}
