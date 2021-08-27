package br.com.gulafood.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor; 

/**
 * 
 * @author winston
 *
 *
 *
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class Restaurante implements Serializable {;
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private BigDecimal taxaFrete;
	
	
	
	@JsonIgnore
	//@Embedded // indicando que esta propriedade e de um tipo incorporando a classe restaurante 
	@ManyToOne
	private Endereco endereco;//Eduardo 
	
	@ManyToOne
	private Cozinha cozinha;
	
	
	@JsonIgnore
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataCadastro;
		
	@JsonIgnore
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate atualizacaoCadastro;
		
	
	/* relacionamento muitos para muitos e decalarando o nome das chaves estrangeiras na tabela intermediaria */
	@JsonIgnore
	@ManyToMany 
	@JoinTable(name = "restaurante_forma_pagamento",joinColumns = @JoinColumn(name ="restaurante_id"),
	inverseJoinColumns = @JoinColumn(name = "forma_pagamento_id"))
	private List<FormaPagamento> formasPagamento = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "restaurante")
	private List<Produto> produtos = new ArrayList<>();
	
	@OneToMany(mappedBy = "restauranteEndereco")
	private List<Endereco> enderecosRestaurante = new ArrayList<>();
	
	@PrePersist // coloca a data de cadatro do sistema
	public void prePersist() {
		
		setDataCadastro(LocalDate.now());
		setAtualizacaoCadastro(LocalDate.now());
	}
	
	
	

}// aula 6.6
