package br.com.gulafood.exception;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ErroException {
	
	private String titulo;
	private LocalDate data;
	
	List<erros> erroUsuario;
	
	@Getter
	@AllArgsConstructor
	public static class erros
	{
		
		private String nome;
		
		private String mensagem;
		
		
	}
}
