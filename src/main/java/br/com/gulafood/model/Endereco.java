package br.com.gulafood.model;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class Endereco {
	
	private String cep;

}
