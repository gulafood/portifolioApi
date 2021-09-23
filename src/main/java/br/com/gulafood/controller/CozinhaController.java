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

	
	@GetMapping
	public List<Cozinha> todas() {

		return cozinhaServicos.todasCozinha();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void salvar(@RequestBody Cozinha cozinha) {

		cozinhaServicos.salvarCozinha(cozinha);
	}

	@GetMapping("/{id}")
	public Cozinha buscar(@PathVariable Long id) {

		return cozinhaServicos.buscarCozinha(id);

	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Cozinha atualizar(@PathVariable Long id, @RequestBody Cozinha atualiza) {

		Cozinha atualizar = cozinhaServicos.buscarCozinha(id);
		
			BeanUtils.copyProperties(atualiza, atualizar,"id");
			 return cozinhaServicos.salvarCozinha(atualizar);
			 
	}	
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long id) {

		cozinhaServicos.deletarCozinha(id);

	}

}
