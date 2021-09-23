package br.com.gulafood.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.gulafood.Repository.RestauranteRepository;
import br.com.gulafood.exception.EntidadeNaoExiste;
import br.com.gulafood.model.Restaurante;

/**
 * 
 * @author winston
 *
 */

@Service
public class RestauranteServicos {

	private static final String MSG_RESTAURANTE_NAO_EXISTE = 
			"Restaurante nao exite";
	
	
	@Autowired
	private RestauranteRepository restauranteRepository;
	
	@Transactional
	public Restaurante buscarRestaurante(Long restaurante){
		
		return restauranteRepository.findById(restaurante).orElseThrow(
				()-> new EntidadeNaoExiste(String.format(MSG_RESTAURANTE_NAO_EXISTE)));
	}
	
	@Transactional
	public List<Restaurante> todosRestaurantes(){
		
		return restauranteRepository.findAll();
	}
	
	@Transactional
	public Restaurante salvarRestaurante(Restaurante restaurante) {
		
		return restauranteRepository.save(restaurante);
	}
	
	@Transactional
	public void deletarRestaurante(Long id) {
		
		try {
			restauranteRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoExiste(String.format(MSG_RESTAURANTE_NAO_EXISTE));	
		} 
		
	}
	
	
}








