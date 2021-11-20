package br.com.gulafood.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ExceptionError extends RuntimeException {


	private static final long serialVersionUID = 1L;

	public ExceptionError(String mensagem) {
		super(mensagem);
	}
	
	public ExceptionError(Long id) {
		
		this(String.format("Não existe este produto com codigo: "+ id));
	}
}
