package br.com.gulafood.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntidadeNaoExiste2 extends RuntimeException {


	private static final long serialVersionUID = 1L;

	public EntidadeNaoExiste2(String mensagem) {
		super(mensagem);
	}
}
