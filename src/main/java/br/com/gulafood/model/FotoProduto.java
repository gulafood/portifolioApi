package br.com.gulafood.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import lombok.Data;


@Data
public class FotoProduto {
	
	@Id
	private long id;
	
	@Lob
	private byte[] foto;
	
	

}
