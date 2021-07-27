package br.com.gulafood.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gulafood.Repository.RestauranteRepository;
import br.com.gulafood.model.Restaurante;


/**
 * 
 * @author Eduardo Santana da Cruz
 *
 */

@RestController
@RequestMapping("/restaurante")
public class RestauranteController {
	@Autowired
	private RestauranteRepository restauranteRepository;

	
	@GetMapping
	List<Restaurante> listar() {
		return restauranteRepository.findAll();
	}
	
	@GetMapping("/{buscaId}")
	public ResponseEntity<?>buscarPorId(@PathVariable Long buscaId){
		Optional<Restaurante> restaurante = restauranteRepository.findById(buscaId);
		
		
		if (restaurante.isPresent()) {
			return ResponseEntity.ok(restaurante.get());
			
		}
		return ResponseEntity.notFound().build();
	
	}

}
