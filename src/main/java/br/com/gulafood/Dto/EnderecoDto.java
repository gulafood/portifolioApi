package br.com.gulafood.Dto;

import br.com.gulafood.model.Cidade;
import br.com.gulafood.model.Endereco;

/**
 * 
 * @author winston
 *
 *
 *         classe dto este tranfere dados, apenas os dados que foi solicitado e
 *         tira o monitoramento da jpa este nao e monitorado mais e um obj que
 *         esta independente da conexao com banco de dados tirando minhas
 *         responsabilidades com transações com banco
 *
 */

public class EnderecoDto {

	private Long id;
	private String cep;
	private String lograduro;
	private String numero;
	private String complemento;
	private String bairro;

	private Cidade cidade;

	public EnderecoDto() {
	}

	// este construtor dto tem como paramentro uma entidade endereco e este pega
	// esta entidade e copia para o dto
	public EnderecoDto(Endereco endereco) {

		id = endereco.getId();
		cep = endereco.getCep();
		lograduro = endereco.getLograduro();
		numero = endereco.getNumero();
		complemento = endereco.getComplemento();
		bairro = endereco.getBairro();
		cidade = endereco.getCidade();

	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLograduro() {
		return lograduro;
	}

	public void setLograduro(String lograduro) {
		this.lograduro = lograduro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

}
