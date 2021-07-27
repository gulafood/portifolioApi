package br.com.gulafood.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gulafood.model.FormaPagamento;

public interface FormaPagamentoRepository extends JpaRepository<FormaPagamento, Long>{

}
