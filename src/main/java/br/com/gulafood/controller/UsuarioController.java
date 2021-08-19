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

import br.com.gulafood.model.Usuario;
import br.com.gulafood.services.UsuarioServicos;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioServicos servicoUsuario;
	
	
	@GetMapping
	public List<Usuario> todos(){
		
		return servicoUsuario.todosUsuario();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario salvar(@RequestBody Usuario usuario) {
		
		return	servicoUsuario.salvarUsuario(usuario);
		
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> buscarId(@PathVariable Long id){
		
		Optional<Usuario> usuarioId = servicoUsuario.buscarUsuario(id);
		
		return (usuarioId.isPresent()) ? ResponseEntity.status(HttpStatus.NO_CONTENT).body(usuarioId.get()):
			ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void atualizar(@PathVariable Long id , @RequestBody Usuario atualiza) {
		
		servicoUsuario.buscarUsuario(id).map(usuarios->{
			atualiza.setId(usuarios.getId());
			return servicoUsuario.salvarUsuario(atualiza);
			
		}).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Long id){
		
		try {
			servicoUsuario.buscarUsuario(id).map(usuarios->{
				servicoUsuario.deletarUsuario(usuarios);
				return Void.TYPE;
				
			}).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
			
		} catch (DataIntegrityViolationException e) {
			
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
		
		return ResponseEntity.noContent().build();
	}
	
	
	
	
}




































