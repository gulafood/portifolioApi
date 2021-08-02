package br.com.gulafood.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gulafood.Repository.RestauranteRepository;
import br.com.gulafood.model.Restaurante;

/**
 * 
 * @author winston
 *
 */

@Service
public class RestauranteServicos {

	@Autowired
	private RestauranteRepository restauranteRepository;
	
	@Transactional
	public Optional<Restaurante> buscarRestaurante(Long restaurante){
		
		return restauranteRepository.findById(restaurante);
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
	public void deletarRestaurante(Restaurante restaurante) {
		
		restauranteRepository.delete(restaurante);
	}
	
	
}








