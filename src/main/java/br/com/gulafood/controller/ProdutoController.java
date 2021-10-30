package br.com.gulafood.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.gulafood.model.Produto;
import br.com.gulafood.services.ProdutoServicos;

/**
 * 
 * @author winston
 *
 *      
 */

@RestController
@RequestMapping("/produtos")

public class ProdutoController {

	@Autowired
	private ProdutoServicos servicoProdutos;
	
	@GetMapping
	public List<Produto> find(){
		
		return servicoProdutos.buscarProdutoId();
	}

	@GetMapping("/nome/produto")
	public List<Produto> pesquisarPorNomeProdutos( String nome) {

		return servicoProdutos.buscarProdutoPorNomes(nome.trim().toUpperCase());
	}

	@PostMapping
	public Produto salvar(@RequestBody Produto produto) {

		return servicoProdutos.salvarProduto(produto);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void atualiza(@PathVariable Long id, @RequestBody Produto atualizar) {

		servicoProdutos.buscarProduto(id).map(produtos -> {

			atualizar.setId(produtos.getId());
			return servicoProdutos.salvarProduto(atualizar);
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long id) {

		servicoProdutos.buscarProduto(id).map(produtos -> {
			servicoProdutos.deletarProduto(id);
			return Void.TYPE;

		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

}
