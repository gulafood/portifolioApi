package br.com.gulafood.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gulafood.model.FotoProduto;
import br.com.gulafood.model.FotoProdutoFile;
import br.com.gulafood.model.FotoProdutoModel;
import br.com.gulafood.model.Produto;
import br.com.gulafood.services.FotoServicos;

@RestController
@RequestMapping("/foto/produtos/{id}/foto")
public class FotoProdutoController {
	
	@Autowired
	private FotoServicos servicoFotoProduto;
	
	@PutMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public FotoProdutoModel atualizar(@PathVariable Long id, @Valid FotoProdutoFile fotoProduto) {
		
		Produto produtos = new Produto();
		
		//Long  produtoId = produtos.getId();
		
		
		FotoProduto foto = new FotoProduto();
		foto.setProduto(produtos);
		
		FotoProduto fotoSalva = servicoFotoProduto.salvar(foto);
		
		return null;
		
	}

}
