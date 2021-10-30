package br.com.gulafood.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.gulafood.Repository.ProdutoRepository;
import br.com.gulafood.model.FotoProduto;

@Service
public class FotoServicos {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Transactional
	public FotoProduto salvar(FotoProduto foto) {
		
		return produtoRepository.save(foto);
	}

}
