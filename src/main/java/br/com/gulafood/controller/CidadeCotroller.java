package br.com.gulafood.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.gulafood.model.Cidade;
import br.com.gulafood.model.Estado;
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

	@GetMapping
	public List<Cidade> todas() {
		return servicosCidade.todasCidade();
	}

	@GetMapping("/{id}")
	public Cidade buscar(@PathVariable Long id) {

		return servicosCidade.buscaCidades(id);

	}

	@PostMapping
	public Cidade salvar(@RequestBody Cidade cidade) {

		Long cidadeId = cidade.getEstado().getId();

		Estado estado = servicosCidade.buscarEstado(cidadeId);

		cidade.setEstado(estado);
		return servicosCidade.salvarCidade(cidade);
	}
	

	@PutMapping("/{id}")
	public Cidade atualiza(@PathVariable Long id, @RequestBody Cidade atualiza) {

		Cidade atualizar = servicosCidade.buscaCidades(id);

		BeanUtils.copyProperties(atualiza, atualizar, "id", "estado");/* <= evitar deixar como null */
		return servicosCidade.salvarCidade(atualizar);

	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long id) {

			servicosCidade.deletarCidade(id);
			

	}
	
//	@DeleteMapping("/{id}") 
//	public ResponseEntity<?> deletar(@PathVariable Long id) {
//
//		try {
//			
//				servicosCidade.deletarCidade(id);
//
//		} catch (DataIntegrityViolationException e) {
//
//			return ResponseEntity.status(HttpStatus.CONFLICT).build();
//		}
//		return ResponseEntity.noContent().build();
//	}


}
