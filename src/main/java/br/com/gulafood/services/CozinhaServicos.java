package br.com.gulafood.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gulafood.Repository.CozinhaRepository;
import br.com.gulafood.model.Cozinha;

/**
 * 
 * @author winston
 *
 *         classe de servicos que e delegada pela classe controller
 */

@Service
public class CozinhaServicos {

	@Autowired
	private CozinhaRepository servicoCozinha;

	@Transactional // busca uma cozinha por id

	public Optional<Cozinha> buscarCozinha(Long cozinha) {

		return servicoCozinha.findById(cozinha);
	}

	@Transactional // busca todas as cozinhas
	public List<Cozinha> todasCozinha() {

		return servicoCozinha.findAll();
	}

	@Transactional // deletar uma cozinha
	public void deletarCozinha(Cozinha cozinha) {

		servicoCozinha.delete(cozinha);
	}

	@Transactional // salva uma cozinha
	public Cozinha salvarCozinha(Cozinha cozinha) {

		return servicoCozinha.save(cozinha);
	}

}
