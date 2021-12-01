package br.com.gulafood.exception;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MensagemErro {

	private List<CampoMensagens> camposErro;

	// classe tratamento de erro de campos por parte de status 4xx
	@Getter
	@AllArgsConstructor
	public static class CampoMensagens {

		private String nome;
		private String mensagem;

	}

}
