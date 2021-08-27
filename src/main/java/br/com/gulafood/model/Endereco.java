package br.com.gulafood.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author winston
 *
 *
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
//@Embeddable // esta anotação indica que esta e imcorporada em uma entidade e uma parte de uma entidade 
public class Endereco implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "endereco_cep")
	private String cep;
	@Column(name = "endereco_logradouro")
	private String lograduro;
	@Column(name = "endereco_numero")
	private String numero;
	@Column(name = "endereco_complemento")
	private String complemento;
	@Column(name = "endereco_bairro")
	private String bairro;

	@ManyToOne
	@JoinColumn(name = "endereco_cidade_id")
	private Cidade cidade;
	
	@ManyToOne
	private Usuario usuarioEndereco;
	
	@ManyToOne
	private Restaurante restauranteEndereco;

}
