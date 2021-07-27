package br.com.gulafood.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gulafood.Repository.FormaPagamentoRepository;
import br.com.gulafood.model.FormaPagamento;

/**
 * 
 * @author winston
 * 
 *         classe servico, esta faz a percistencia delagada pela controller
 */
@Service
public class FormaPagamentoServicos {

	@Autowired
	private FormaPagamentoRepository tipoPagamentoServico;

	@Transactional // busca todas as formas de pagamento existente no banco
	public List<FormaPagamento> todasForma() {

		return tipoPagamentoServico.findAll();
	}

	@Transactional // busca uma forma de pagamento persistida no banco
	public Optional<FormaPagamento> buscarForma(Long forma) {

		return tipoPagamentoServico.findById(forma);
	}

	@Transactional // deleta uma forma de pagamento existente no banco
	public void deletarForma(FormaPagamento tipo) {

		tipoPagamentoServico.delete(tipo);
	}

	@Transactional // salva uma forma de pagamento no banco de dados
	public FormaPagamento salvarForma(FormaPagamento forma) {

		return tipoPagamentoServico.save(forma);
	}

	@Transactional // atualiza uma forma de pagamento existente no banco
	public FormaPagamento atualizarForma(FormaPagamento forma) {

		return tipoPagamentoServico.save(forma);
	}
}
