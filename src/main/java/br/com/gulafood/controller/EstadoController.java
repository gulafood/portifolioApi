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

import br.com.gulafood.exception.EntidadeComIntegracaoAoutra;
import br.com.gulafood.exception.EntidadeNaoExiste;
import br.com.gulafood.model.Estado;
import br.com.gulafood.services.EstadoServicos;

/**
 * 
 * @author winston
 *
 *
 *         classe controller estado com metedos de entrada do usuario esta
 *         classe delega os metados para calsse servicos
 */

@RestController
@RequestMapping("/estados")
public class EstadoController {

	@Autowired
	private EstadoServicos servicosEstado;

	@GetMapping 
	public List<Estado> todos() {
		return servicosEstado.todosEstado();
	}

	@PostMapping 
	@ResponseStatus(HttpStatus.CREATED)
	public Estado salvar(@RequestBody Estado estado) {

		return servicosEstado.salvarEstado(estado);
	}

	@GetMapping("/{id}") 
	public ResponseEntity<Estado> buscar(@PathVariable Long id) {

		Optional<Estado> estadoId = servicosEstado.buscaEstado(id);

		return (estadoId.isPresent()) ? ResponseEntity.status(HttpStatus.OK).body(estadoId.get())
				: ResponseEntity.notFound().build();
	}

	@PutMapping("/{id}") 
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualizar(@PathVariable Long id, @RequestBody Estado atualiza) {

		servicosEstado.buscaEstado(id).map(estados -> {
			atualiza.setId(estados.getId());
			return servicosEstado.salvarEstado(atualiza);
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	@DeleteMapping("/{id}") 
	public ResponseEntity<?> deletar(@PathVariable Long id) {

		try {
			servicosEstado.buscaEstado(id).map(estados -> {
				servicosEstado.deletarEstado(estados);
				return Void.TYPE;
			}).orElseThrow(() -> new EntidadeNaoExiste("nao existe"));

		} catch (DataIntegrityViolationException e) {

			throw new EntidadeComIntegracaoAoutra("nao pode excluir");
		}
		return ResponseEntity.noContent().build();
	}
	
	

}
