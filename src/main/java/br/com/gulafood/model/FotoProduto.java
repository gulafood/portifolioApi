package br.com.gulafood.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class FotoProduto {
	
	@Id
	@Column(name = "foto_id")
	private long id;
	private String nomeFoto;
	
	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	private Produto produto;

}
