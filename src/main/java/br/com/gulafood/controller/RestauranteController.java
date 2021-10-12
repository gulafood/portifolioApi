package br.com.gulafood.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.gulafood.model.Restaurante;
import br.com.gulafood.services.RestauranteServicos;

/**
 * 
 * @author Eduardo Santana da Cruz
 *
 *		  inicio com a classe fez as configurações com as anotações fez o metedo buscar por id 
 */

/**
 * 
 * @author winston
 *
 *         termino de implementar os codigos restantes da classe
 */

@RestController
@RequestMapping("/restaurante")
public class RestauranteController {

	@Autowired
	private RestauranteServicos servicosRestaurantes;

	@GetMapping // busca todos os restaurantes de uma tabela
	ResponseEntity<List<Restaurante>>  listar() {

		//
		
		List<Restaurante> atualizar = servicosRestaurantes.todosRestaurantes();
		
		 return ResponseEntity.ok().header(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "http://localhost:8080/requisição.html")
				 .body(atualizar);
	}

	@PostMapping // salva um novo restaurante na tabela
	@ResponseStatus(HttpStatus.CREATED)
	public Restaurante salvar(@RequestBody Restaurante restaurante) {

		return servicosRestaurantes.salvarRestaurante(restaurante);
	}

	@GetMapping("/{id}") 
	public Restaurante buscarPorId(@PathVariable Long id) {

		return servicosRestaurantes.buscarRestaurante(id);

	}

//	@PutMapping("/{id}") // atualiza uma cidade no banco e impede que os outros dados na hora da // atualização seja como null
//	public ResponseEntity<?> atualiza(@PathVariable Long id, @RequestBody Restaurante atualiza) {
//
//		Restaurante atualizar = servicosRestaurantes.buscarRestaurante(id).orElse(null);
//
//		if (atualizar != null) {
//			BeanUtils.copyProperties(atualiza, atualizar, "id", "formasPagamento", "enderecosRestaurante","dataCadastro", "produtos");/*<= evitar deixar como null*/
//			atualizar = servicosRestaurantes.salvarRestaurante(atualizar);
//
//			return ResponseEntity.ok(atualizar);
//		}
//
//		return ResponseEntity.notFound().build();
//	}

	@DeleteMapping("/{id}") 
	public void deletar(@PathVariable Long id) {

		
			servicosRestaurantes.deletarRestaurante(id);
				
	}
		

}
