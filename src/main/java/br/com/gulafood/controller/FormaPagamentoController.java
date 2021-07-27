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

import br.com.gulafood.model.FormaPagamento;
import br.com.gulafood.services.FormaPagamentoServicos;

/**
 * 
 * @author winston
 * 
 *         classe controller de persistencia no banco delegando para a classe
 *         servicos
 */

@RestController
@RequestMapping("/pagamentos")
public class FormaPagamentoController {

	@Autowired
	private FormaPagamentoServicos tipoServicos;

	@GetMapping // busca todas as formas de pagamentos delegando para a classe servico
	public List<FormaPagamento> todas() {

		return tipoServicos.todasForma();
	}

	@PostMapping // salva uma forma de pagamento delegando para a classe servico
	@ResponseStatus(HttpStatus.CREATED)
	public void salvar(@RequestBody FormaPagamento formaPagamento) {

		tipoServicos.salvarForma(formaPagamento);
	}

	@GetMapping("/{id}") // busca uma forma de pagamento delegando para a classe servico
	public ResponseEntity<FormaPagamento> bucar(@PathVariable Long id) {

		Optional<FormaPagamento> idForma = tipoServicos.buscarForma(id);

		return (idForma.isPresent()) ? ResponseEntity.status(HttpStatus.OK).body(idForma.get())
				: ResponseEntity.notFound().build();

	}

	@PutMapping("/{id}") // atualizar uma forma de pagamento delegando para a classe servico
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualizar(@PathVariable Long id, @RequestBody FormaPagamento atualizarForma) {

		tipoServicos.buscarForma(id).map(formaPagamentos -> {

			atualizarForma.setId(formaPagamentos.getId());
			return tipoServicos.salvarForma(atualizarForma);

		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

	}

	@DeleteMapping("{/id}") // deletar uma forma de pagamento delegando para a classe servico
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long id) {

		try {
			tipoServicos.buscarForma(id).map(formaPagamentos -> {

				tipoServicos.deletarForma(formaPagamentos);
				return Void.TYPE;

			}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

		} catch (DataIntegrityViolationException e) {

			ResponseEntity.status(HttpStatus.CONFLICT).build();
		}

	}

}
