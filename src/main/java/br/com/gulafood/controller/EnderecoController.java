package br.com.gulafood.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
import org.springframework.web.server.ResponseStatusException;

import br.com.gulafood.Repository.EnderecoRepository;
import br.com.gulafood.model.Endereco;
import br.com.gulafood.services.EnderecoServicos;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

	@Autowired
	private EnderecoServicos servicosEnderecos;
	
	@Autowired
	private EnderecoRepository er;
	
	@GetMapping
	public List<Endereco> todos(){
		
		return er.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Endereco salvar(@RequestBody Endereco endereco) {

		return servicosEnderecos.salvarEndereco(endereco);
	}

	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> atualiza(@PathVariable Long id, @RequestBody Endereco atualiza) {

		Endereco atualizar = servicosEnderecos.buscarEndereco(id).orElse(null);

		if (atualizar != null) {

			BeanUtils.copyProperties(atualiza, atualizar);
			servicosEnderecos.salvarEndereco(atualizar);

			return ResponseEntity.ok(atualizar);
		}

		return ResponseEntity.notFound().build();
	}

	
	@GetMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Long id) {

		try {

			servicosEnderecos.buscarEndereco(id).map(enderecos -> {

				servicosEnderecos.deletarEndereco(id);
				return Void.TYPE;
			}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

		} catch (DataIntegrityViolationException e) {

			return ResponseEntity.status(HttpStatus.CONFLICT).build();

		}
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
