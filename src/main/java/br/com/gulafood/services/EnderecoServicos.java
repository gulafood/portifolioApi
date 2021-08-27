package br.com.gulafood.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gulafood.Repository.EnderecoRepository;
import br.com.gulafood.model.Endereco;

/**
 * 
 * @author winston
 *
 */

@Service
public class EnderecoServicos {
	
	@Autowired
	private EnderecoRepository enderecoRepository;

	@Transactional
	public Endereco salvarEndereco(Endereco endereco) {
		
		return enderecoRepository.save(endereco);
	}
	
	@Transactional
	public Optional<Endereco> buscarEndereco(Long id) {
		
		return enderecoRepository.findById(id);
	}
	
	@Transactional
	public void deletarEndereco(Long id) {
		
		enderecoRepository.deleteById(id);
	}
	
}
