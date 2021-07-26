package br.com.gulafood.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gulafood.Repository.CozinhaRepository;
import br.com.gulafood.model.Cozinha;

@RestController
@RequestMapping("/cozinhas")
public class CozinhaController {
	
	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	@GetMapping
	public List<Cozinha> todas(){
		
		return cozinhaRepository.findAll();
	}
	
	@PostMapping
	public void salvar(@RequestBody Cozinha cozinha) {
		
		cozinhaRepository.save(cozinha);
	}
	
	@GetMapping("/{id}")// estou fazendo nao mexer
	public ResponseEntity<Cozinha> buscar(@PathVariable Long id){
		
	    Optional<Cozinha> cozinha = cozinhaRepository.findById(id);
		
	    if( cozinha.isPresent()) 
	    	
	    	ResponseEntity.status(HttpStatus.OK).body(cozinha.get());
	    
	    System.out.println("teste");
	    System.out.println("teste");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		
		
	}

}
