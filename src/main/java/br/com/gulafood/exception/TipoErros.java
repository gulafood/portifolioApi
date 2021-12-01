package br.com.gulafood.exception;

import lombok.Getter;

@Getter
public enum TipoErros {
	
	NAO_EXISTE_ESTE_PRODUTO("/nao-existe-este-produto", "Não existe este produto"),
	CAMPO_EM_BRANCO("/campo-em-branco", "Campo em branco");
	
	private String title;
	private String uri;
	
	
	private TipoErros(String path, String title) {
		this.title = title;
		this.uri = "localhost:8080/produtos" + path;
	}
	
	

}
