package br.com.gulafood.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class Endereco {
	@Column(name = "endereco_cep")
	private String cep;
	@Column(name = "endereco_locaduro")
	private String lograduro;
	@Column(name = "endereco_numero")
	private String numero;
	@Column(name = "enderenco_complemento")
	private String complemento;
	@Column(name = "enderenco_bairro")
	private String bairro;
	

}
