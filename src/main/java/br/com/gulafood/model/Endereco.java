package br.com.gulafood.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

/**
 * 
 * @author winston
 *
 *
 */

@Data
@Embeddable // esta anotação indica que esta e imcorporada em uma entidade e uma parte de uma entidade 
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

	@ManyToOne
	@JoinColumn(name = "endereco_cidade_id")
	private Cidade cidade;

}
