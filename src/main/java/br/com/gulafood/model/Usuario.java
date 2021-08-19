package br.com.gulafood.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String email;
	
	@Column(nullable = false, length = 6)
	private String senha;
	
	

	@Column(length = 12)
	private String telefone;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDateTime dataCadastro;
	

	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "usuario_grupo" , joinColumns = @JoinColumn(name = "usuario_id"),
				inverseJoinColumns = @JoinColumn(name = "grupo_id"))
	private List<Grupo> grupos = new ArrayList<>();
	
	
	
	@PrePersist // coloca a data de cadatro do sistema
	public void prePersist() {
		
		setDataCadastro(LocalDateTime.now());
		
	}
	
	
	
}
