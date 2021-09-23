package br.com.gulafood.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gulafood.Repository.EstadoRepository;
import br.com.gulafood.model.Estado;

@Service
public class EstadoServicos {

	@Autowired
	private EstadoRepository estadoRepository;
	
	@Transactional // busca um estados no banco
	public Optional<Estado> buscaEstado(Long estado){
		
		return estadoRepository.findById(estado);
	}
	
	@Transactional // busca todos os estados do banco
	public List<Estado> todosEstado(){
		
		return estadoRepository.findAll();
	}
	
	@Transactional // salva um estado no banco
	public Estado salvarEstado( Estado estado) {
		
		return estadoRepository.save(estado);
	}
	
	@Transactional // deleta um estado persistido no banco
	public void deletarEstado(Estado estado) {
		
		estadoRepository.delete(estado);
	}
	
	
	
}















