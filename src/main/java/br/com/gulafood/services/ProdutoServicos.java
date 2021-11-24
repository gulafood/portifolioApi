package br.com.gulafood.services;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.Part;
import javax.transaction.Transactional;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.gulafood.Repository.ProdutoRepository;
import br.com.gulafood.exception.ExceptionError;
import br.com.gulafood.model.Produto;

/**
 * 
 * @author winston
 *
 */

@Service
public class ProdutoServicos {

	
	
	@Autowired
	private ProdutoRepository produtoRepository;

	@Transactional
	public List<Produto> buscarProdutoId() {

		return produtoRepository.findAll();
	}
	
	@Transactional
	public List<Produto> buscarProdutoPorNomes(String nome) {

		return produtoRepository.findBynome(nome);
	}

	@Transactional
	public Produto buscarProduto(Long id) {

		return produtoRepository.findById(id).orElseThrow(
				() -> new ExceptionError(id));
	}

	@Transactional
	public Produto salvarProduto(Produto produto) {

		return produtoRepository.save(produto);
	}

	@Transactional
	public void deletarProduto(Long id) {

		try {
			produtoRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ExceptionError(id);
		}

	}

	@Transactional
	public byte[] salvarFoto(Long id, Part arquivo) {

		Optional<Produto> fotoProdutos = produtoRepository.findById(id);

		return fotoProdutos.map(foto -> {

			try {

				InputStream image = arquivo.getInputStream();
				byte[] bytes = new byte[(int) arquivo.getSize()];
				IOUtils.readFully(image, bytes);
				foto.setFoto(bytes);
				produtoRepository.save(foto);
				image.close();

				return bytes;
			} catch (IOException e) {

				return null;
			}

		}).orElse(null);
	}

}
