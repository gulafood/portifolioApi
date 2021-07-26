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

import br.com.gulafood.Repository.CozinhaRepository;
import br.com.gulafood.model.Cozinha;

@RestController
@RequestMapping("/cozinhas")
public class CozinhaController {

	@Autowired
	private CozinhaRepository cozinhaRepository;

	@GetMapping // busca todas as cozinha do banco
	public List<Cozinha> todas() {

		return cozinhaRepository.findAll();
	}

	@PostMapping // salva uma cozinha no banco
	@ResponseStatus(HttpStatus.CREATED)
	public void salvar(@RequestBody Cozinha cozinha) {

		cozinhaRepository.save(cozinha);
	}

	@GetMapping("/{id}") // pesquisa por uma cozinha por id
	public ResponseEntity<Cozinha> buscar(@PathVariable Long id) {

		Optional<Cozinha> cozinha = cozinhaRepository.findById(id);

		return (cozinha.isPresent()) ? ResponseEntity.status(HttpStatus.OK).body(cozinha.get())
				: ResponseEntity.status(HttpStatus.NOT_FOUND).build();

	}

	@PutMapping("/{id}") // atualiza uma cozinha no banco
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualizar(@PathVariable Long id, @RequestBody Cozinha atualiza) {

		cozinhaRepository.findById(id).map(cozinha -> {
			atualiza.setId(cozinha.getId());
			return cozinhaRepository.save(atualiza);

		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

	}

	@DeleteMapping("/{id}") // deleta uma cozinha se ela nao estiver com integridade a uma classe fk
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long id) {

		try {

			cozinhaRepository.findById(id).map(cozinhaId -> {
				cozinhaRepository.delete(cozinhaId);
				return Void.TYPE;

			}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

		} catch (DataIntegrityViolationException e) {

			ResponseEntity.status(HttpStatus.CONFLICT).build();
		}

	}

}
