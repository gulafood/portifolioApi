package br.com.gulafood.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.gulafood.Repository.CozinhaRepository;
import br.com.gulafood.exception.EntidadeComIntegracaoAoutra;
import br.com.gulafood.exception.EntidadeNaoExiste;
import br.com.gulafood.model.Cozinha;

/**
 * 
 * @author winston
 *
 *         classe de servicos que e delegada pela classe controller
 */

@Service
public class CozinhaServicos {

	private static final String MSG_COZINHA_NAO_PODE_SER_REMOVIDA = 
			"Cozinha de código %d não pode ser removida, pois está em uso";

	private static final String MSG_COZINHA_NAO_ENCONTRADA = 
			"Não existe um cadastro de cozinha com código ";

	@Autowired
	private CozinhaRepository servicoCozinha;

	
	
	@Transactional
	public List<Cozinha> todasCozinha() {

		return servicoCozinha.findAll();
	}

	@Transactional
	public Cozinha buscarCozinha(Long cozinha) {

		return servicoCozinha.findById(cozinha)
				.orElseThrow(() -> new EntidadeNaoExiste(MSG_COZINHA_NAO_ENCONTRADA + cozinha));
	}

	@Transactional
	public void deletarCozinha(Long id) {

		try {
			servicoCozinha.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoExiste(String.format(MSG_COZINHA_NAO_ENCONTRADA, id));

		} catch (DataIntegrityViolationException e) {
			throw new EntidadeComIntegracaoAoutra(String.format(MSG_COZINHA_NAO_PODE_SER_REMOVIDA, id));
		}
	}

	@Transactional 
	public Cozinha salvarCozinha(Cozinha cozinha) {

		return servicoCozinha.save(cozinha);
	}

}
