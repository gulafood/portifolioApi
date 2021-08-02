package br.com.gulafood.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Usuario implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Email
	@NotBlank
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private String email;
	
	private Long id;
	
	@Email
	@NotBlank
	private String nome;
	
	@NotBlank
	@Column( length = 4)
	private String senha;

	public Usuario(@NotBlank String senha) {
		super();
		this.senha = senha;
	}
	
	
	
}
