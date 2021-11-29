package br.com.gulafood.exception;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProblemaException {
	
	private String titulo;
	private LocalDate data;
	
	
	
	@Getter
	@AllArgsConstructor
	public static class erros
	{
		
		private String nome;
		
		private String mensagem;
		
		
	}
}
