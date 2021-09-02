package br.com.gulafood.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gulafood.Repository.ProdutoRepository;
import br.com.gulafood.model.Produto;

@Service
public class ProdutoServicos {

	@Autowired
	private ProdutoRepository produtoRepository;

	@Transactional
	public Optional<Produto> buscarProduto(Long id) {

		return produtoRepository.findById(id);
	}

	@Transactional
	public Produto salvarProduto(Produto produto) {

		return produtoRepository.save(produto);
	}

	@Transactional
	public void deletarProduto(Long id) {

		produtoRepository.deleteById(id);
		;
	}

	@Transactional
	public List<Produto> buscarProdutoPorNomes(String nome) {

		return produtoRepository.findBynomeContaining(nome);
	}

}
