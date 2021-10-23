package br.com.gulafood.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.gulafood.model.Produto;

/**
 * 
 * @author winston
 *
 */
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
	@Query("select u from Produto u where u.nome  like  %?1%")
	List<Produto> findBynome(String nome);

}
