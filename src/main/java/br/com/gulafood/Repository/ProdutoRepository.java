package br.com.gulafood.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gulafood.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	List<Produto> findBynomeContaining(String nome);

}
