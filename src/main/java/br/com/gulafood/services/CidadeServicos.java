package br.com.gulafood.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gulafood.Repository.CidadeRepository;
import br.com.gulafood.model.Cidade;

@Service
public class CidadeServicos {

	@Autowired
	private CidadeRepository cidadeRepository;
	
	
	@Transactional
	public Optional<Cidade> buscaCidades(Long id){
		
		return cidadeRepository.findById(id);
	}
	
	@Transactional
	public List<Cidade> todasCidade(){
		
		return cidadeRepository.findAll();
	}
	@Transactional
	public Cidade salvarCidade( Cidade cidade) {
		
			
			return cidadeRepository.save(cidade);
	
	}
	
	@Transactional
	public void deletarCidade( Cidade cidade) {
		
		cidadeRepository.delete(cidade);
	}
	
}

















