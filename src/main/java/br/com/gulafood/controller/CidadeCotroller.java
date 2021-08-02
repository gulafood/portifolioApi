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

import br.com.gulafood.model.Cidade;
import br.com.gulafood.services.CidadeServicos;

@RestController
@RequestMapping("/cidades")
public class CidadeCotroller {

	@Autowired
	private CidadeServicos servicosCidade;
	
	@GetMapping
	public List<Cidade> todas(){
		return servicosCidade.todasCidade();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cidade> buscar(@PathVariable Long id){
		
		Optional<Cidade> cidades = servicosCidade.buscaCidades(id);
		
		return (cidades.isPresent()) ? ResponseEntity.status(HttpStatus.OK).body(cidades.get()):
			ResponseEntity.noContent().build();
	}
	
	@PostMapping
	public Cidade salvar (Cidade cidade) {
		
		return servicosCidade.salvarCidade(cidade);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualizar(@PathVariable Long id , @RequestBody Cidade atualiza) {
		
		servicosCidade.buscaCidades(id).map(cidades->{
			atualiza.setId(cidades.getId());
			return servicosCidade.salvarCidade(atualiza);
			
		}).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long id) {
		
		try {
			servicosCidade.buscaCidades(id).map(cidades->{
				servicosCidade.deletarCidade(cidades);
				return Void.TYPE;
			}).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
			
		} catch (DataIntegrityViolationException e) {
			
			ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}
	
}
















