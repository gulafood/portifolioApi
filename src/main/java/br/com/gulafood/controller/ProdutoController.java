package br.com.gulafood.controller;

import java.util.List;

import javax.servlet.http.Part;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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
	public List<Produto> findAll(){
		
		return servicoProdutos.buscarTodos();
	}
	

	@GetMapping("/pesquisa")
	public List<Produto> pesquisarPorNomeProdutos( String nome) {

		return servicoProdutos.buscarProdutoPorNomes(nome.trim().toUpperCase());
	}

	@PostMapping
	public Produto salvar(@RequestBody @Valid Produto produto) {

		return servicoProdutos.salvarProduto(produto);
	}

	@PutMapping("/{id}")
	public Produto atualiza(@PathVariable Long id, @RequestBody @Valid Produto atualizar) {

		Produto atualiza = servicoProdutos.buscarProduto(id);
		
		BeanUtils.copyProperties(atualizar, atualiza, "id","foto");
		
			return servicoProdutos.salvarProduto(atualiza);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long id) {

		 servicoProdutos.deletarProduto(id);
	}
	
	@PutMapping("/{id}/foto")
	public byte[] atualizar(@PathVariable Long id, @RequestParam("foto") Part arquivo) {
			
		return	servicoProdutos.salvarFoto(id, arquivo);	
		
	}
	
}
