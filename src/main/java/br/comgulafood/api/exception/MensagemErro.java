package br.comgulafood.api.exception;

import java.time.LocalDateTime;
import java.util.List;

public class MensagemErro {

	private Integer status;
	private LocalDateTime datahora;
	private String mensagemErro;

	private List<CampoMensagens> camposErro;

	// classe tratamento de erro de campos por parte de status 4xx
	public static class CampoMensagens {

		private String nome;
		private String mensagem;

		public CampoMensagens(String nome, String mensagem) {
			super();
			this.nome = nome;
			this.mensagem = mensagem;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getMensagem() {
			return mensagem;
		}

		public void setMensagem(String mensagem) {
			this.mensagem = mensagem;
		}

	}//fim class--

	public List<CampoMensagens> getCamposErro() {
		return camposErro;
	}

	public void setCamposErro(List<CampoMensagens> camposErro) {
		this.camposErro = camposErro;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public LocalDateTime getDatahora() {
		return datahora;
	}

	public void setDatahora(LocalDateTime datahora) {
		this.datahora = datahora;
	}

	public String getMensagemErro() {
		return mensagemErro;
	}

	public void setMensagemErro(String mensagemErro) {
		this.mensagemErro = mensagemErro;
	}

}
