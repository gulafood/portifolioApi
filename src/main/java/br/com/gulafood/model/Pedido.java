package br.com.gulafood.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Pedido implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private BigDecimal subTotal;
	private BigDecimal taxaFrete;
	private BigDecimal valorTotal;
	
	// fazer mapeamento 
	private Endereco enderecoEntrega;
	
	private StatusPedido status;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDateTime dataPedido;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private FormaPagamento tipoPagamento;
	
	@ManyToOne
	@JoinColumn(name = "usario_cliente_id", nullable = false)
	private Usuario usuario;
	
	
	@OneToMany(mappedBy = "pedido")
	private List<ItensPedido> itens = new ArrayList<>();
	
	@PrePersist // coloca a data de cadatro do sistema
	public void prePersist() {

		
		setDataPedido(LocalDateTime.now());
	}
	
}
