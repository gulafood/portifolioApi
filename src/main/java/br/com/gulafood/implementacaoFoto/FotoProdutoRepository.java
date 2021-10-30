package br.com.gulafood.implementacaoFoto;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.gulafood.Repository.ProdutoepositoriesQuery;
import br.com.gulafood.model.FotoProduto;

@Repository
public class FotoProdutoRepository implements ProdutoepositoriesQuery{

	@PersistenceContext
	private EntityManager maneger;
	
	@Transactional
	@Override
	public FotoProduto save(FotoProduto foto) {
		
		return maneger.merge(foto);
	}

}
