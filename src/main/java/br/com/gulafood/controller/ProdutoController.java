package br.com.gulafood.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.Part;

import org.apache.tomcat.util.http.fileupload.IOUtils;
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
import org.springframework.web.server.ResponseStatusException;

import br.com.gulafood.Repository.ProdutoRepository;
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
	
	@Autowired
	private ProdutoRepository fotos;
	
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
	
	@PutMapping("/{id}/foto")
	public byte[] atualizar(@PathVariable Long id, @RequestParam("foto") Part arquivo) {

		Optional<Produto> fotoProdutos = fotos.findById(id);

		return fotoProdutos.map(prFoto -> {

			try {

				InputStream is = arquivo.getInputStream();
				byte[] bytes = new byte[(int) arquivo.getSize()];
				IOUtils.readFully(is, bytes);
				prFoto.setFoto(bytes);
				fotos.save(prFoto);
				is.close();

				return bytes;
			} catch (IOException e) {
				
				return null;
			}

		}).orElse(null);

	}

}
