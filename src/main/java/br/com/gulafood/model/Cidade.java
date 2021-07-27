package br.com.gulafood.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

/**
 * 
 * @author eduardo
 *
 */
@Data
@Entity
public class Cidade {
	@Id
	private Long id;
	private String nome;
	
	
	
}
