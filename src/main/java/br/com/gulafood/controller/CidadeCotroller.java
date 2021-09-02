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

import br.com.gulafood.model.Cidade;
import br.com.gulafood.services.CidadeServicos;

/**
 * 
 * @author winston
 *
 */

@RestController
@RequestMapping("/cidades")
public class CidadeCotroller {

	@Autowired
	private CidadeServicos servicosCidade;
	
	
	@GetMapping// busca todas as cidades no banco 
	public List<Cidade> todas(){
		return servicosCidade.todasCidade();
	}
	
	@GetMapping("/{id}") // busca uma cidade no banco atraves do id
	public ResponseEntity<Cidade> buscar(@PathVariable Long id){
		
		Optional<Cidade> cidades = servicosCidade.buscaCidades(id);
		
		return (cidades.isPresent()) ? ResponseEntity.status(HttpStatus.OK).body(cidades.get()):
			ResponseEntity.noContent().build();
	}
	
	@PostMapping // salva uma cidade no banco 
	public Cidade salvar (@RequestBody Cidade cidade) {
	
		return servicosCidade.salvarCidade(cidade);
	}
	

	
	@PutMapping("/{id}")// atualiza uma cidade no banco e impede que os outros dados na hora da atualização seja como null
	ResponseEntity<?> atualiza(@PathVariable Long id , @RequestBody Cidade atualiza){
		
		Cidade atualizar = servicosCidade.buscaCidades(id).orElse(null);
		
		if(atualizar != null) {
			
			BeanUtils.copyProperties(atualiza, atualizar,"id","estado");/*<= evitar deixar como null*/
			atualizar = servicosCidade.salvarCidade(atualizar);
			return ResponseEntity.ok(atualizar);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	
	@DeleteMapping("/{id}") // deleta uma cidade no banco caso ela nao tenha integridade com outra tabela
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
















