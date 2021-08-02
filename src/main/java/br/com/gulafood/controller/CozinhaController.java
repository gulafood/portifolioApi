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

import br.com.gulafood.model.Cozinha;
import br.com.gulafood.services.CozinhaServicos;

/**
 * 
 * @author winston
 *
 *         classe controller esta realiza todas as entradas pelo usuario e
 *         delega para de servico
 */
@RestController
@RequestMapping("/cozinhas")
public class CozinhaController {

	@Autowired
	private CozinhaServicos cozinhaServicos;

	@GetMapping // busca todas as cozinha do banco
	public List<Cozinha> todas() {

		return cozinhaServicos.todasCozinha();
	}

	@PostMapping // salva uma cozinha no banco
	@ResponseStatus(HttpStatus.CREATED)
	public void salvar(@RequestBody Cozinha cozinha) {

		cozinhaServicos.salvarCozinha(cozinha);
	}

	@GetMapping("/{id}") // pesquisa por uma cozinha por id
	public ResponseEntity<Cozinha> buscar(@PathVariable Long id) {

		Optional<Cozinha> cozinha = cozinhaServicos.buscarCozinha(id);

		return (cozinha.isPresent()) ? ResponseEntity.status(HttpStatus.OK).body(cozinha.get())
				: ResponseEntity.status(HttpStatus.NOT_FOUND).build();

	}

	@PutMapping("/{id}") // atualiza uma cozinha no banco
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualizar(@PathVariable Long id, @RequestBody Cozinha atualiza) {

		cozinhaServicos.buscarCozinha(id).map(cozinha -> {
			atualiza.setId(cozinha.getId());
			return cozinhaServicos.salvarCozinha(atualiza);

		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

	}

	@DeleteMapping("/{id}") // deleta uma cozinha se ela nao estiver com integridade a uma classe fk
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long id) {

		try {
			cozinhaServicos.buscarCozinha(id).map(cozinhaId -> {
				cozinhaServicos.deletarCozinha(cozinhaId);
				return Void.TYPE;

			}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

		} catch (DataIntegrityViolationException e) {

			ResponseEntity.status(HttpStatus.CONFLICT).build();
		}

	}

}
