package br.com.gulafood.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author winston
 *
 * classe forma de pagamento usando as anotação para criar uma tabela no
 * banco e usar os metedos get e set
 *
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FormaPagamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String tipoPagamento;
}
