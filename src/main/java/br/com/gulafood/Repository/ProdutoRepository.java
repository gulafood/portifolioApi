package br.com.gulafood.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gulafood.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
