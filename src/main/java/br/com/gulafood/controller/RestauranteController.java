package br.com.gulafood.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
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
	List<Restaurante> listar() {

		return servicosRestaurantes.todosRestaurantes();
	}

	@PostMapping // salva um novo restaurante na tabela
	@ResponseStatus(HttpStatus.CREATED)
	public Restaurante salvar(@RequestBody Restaurante restaurante) {

		return servicosRestaurantes.salvarRestaurante(restaurante);
	}

	@GetMapping("/{id}") // busca um restaurante na tabela atraves do id
	public ResponseEntity<?> buscarPorId(@PathVariable Long id) {

		Optional<Restaurante> restaurante = servicosRestaurantes.buscarRestaurante(id);

		return (restaurante.isPresent()) ? ResponseEntity.ok(restaurante.get()) : ResponseEntity.notFound().build();

	}

	@PutMapping("/{id}") // atualiza uma cidade no banco e impede que os outros dados na hora da // atualização seja como null
	public ResponseEntity<?> atualiza(@PathVariable Long id, @RequestBody Restaurante atualiza) {

		Restaurante atualizar = servicosRestaurantes.buscarRestaurante(id).orElse(null);

		if (atualizar != null) {
			BeanUtils.copyProperties(atualiza, atualizar, "id", "formasPagamento", "enderecosRestaurante","dataCadastro", "produtos");/*<= evitar deixar como null*/
			atualizar = servicosRestaurantes.salvarRestaurante(atualizar);

			return ResponseEntity.ok(atualizar);
		}

		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}") // deleta um restaurante no banco caso ela nao tenha integridade com outra tabela
	public ResponseEntity<?> deletar(@PathVariable Long id) {

		try {
			servicosRestaurantes.buscarRestaurante(id).map(restaurantes -> {
				servicosRestaurantes.deletarRestaurante(restaurantes);
				return Void.TYPE;

			}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

		} catch (DataIntegrityViolationException e) {

			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}

		return ResponseEntity.noContent().build();
	}

}
