package br.com.gulafood.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import br.com.gulafood.model.Restaurante;
import br.com.gulafood.services.RestauranteServicos;


/**
 * 
 * @author Eduardo Santana da Cruz
 *
 */

@RestController
@RequestMapping("/restaurante")
public class RestauranteController {
	
	
	@Autowired
	private RestauranteServicos servicosRestaurantes;
	
	@GetMapping
	List<Restaurante> listar() {
		
		return servicosRestaurantes.todosRestaurantes();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Restaurante salvar(@RequestBody Restaurante restaurante) {
		
		return servicosRestaurantes.salvarRestaurante(restaurante);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<?>buscarPorId(@PathVariable Long id){
		
		Optional<Restaurante> restaurante = servicosRestaurantes.buscarRestaurante(id);
		
		return (restaurante.isPresent()) ? ResponseEntity.ok(restaurante.get()): 
			ResponseEntity.notFound().build();
	
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void atualizar(@PathVariable Long id , @RequestBody Restaurante restaurante) {
		
		servicosRestaurantes.buscarRestaurante(id).map(restaurantes->{
			restaurante.setId(restaurantes.getId());
			return servicosRestaurantes.salvarRestaurante(restaurantes);
		}).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Long id){
		
		try {
			servicosRestaurantes.buscarRestaurante(id).map(restaurantes->{
				servicosRestaurantes.deletarRestaurante(restaurantes);
				return Void.TYPE;
				
			}).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
			
		} catch (DataIntegrityViolationException e) {

			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
		
		return ResponseEntity.noContent().build();
	}
	

}
