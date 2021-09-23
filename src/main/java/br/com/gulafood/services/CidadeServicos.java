package br.com.gulafood.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.gulafood.Repository.CidadeRepository;
import br.com.gulafood.Repository.EstadoRepository;
import br.com.gulafood.exception.EntidadeComIntegracaoAoutra;
import br.com.gulafood.exception.EntidadeNaoExiste;
import br.com.gulafood.model.Cidade;
import br.com.gulafood.model.Estado;

@Service
public class CidadeServicos {

	private static final String MSG_CIDADE_NAO_PODE_SER_EXCLUIDA = 
			"Cidade nao pode ser excluida ";

	private static final String MSG_CIDADE_NAO_ENCONTRADA = 
			"Nao existe esta cidade com codigo ";

	private static final String MSG_ESTADO_NAO_ENCONTRADO =
			"Nao existe um estado com esse codido ";

	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository  estadoRepository;
	
	
	@Transactional
	public List<Cidade> todasCidade(){
		
		return cidadeRepository.findAll();
	}
	
	
	@Transactional
	public Cidade buscaCidades(Long id){
		
		return cidadeRepository.findById(id).orElseThrow(()-> new EntidadeNaoExiste(
				String.format(MSG_ESTADO_NAO_ENCONTRADO+id)));
	}
	
	
	@Transactional
	public Cidade salvarCidade( Cidade cidade) {
			
			return cidadeRepository.save(cidade);
	
	}
	
	@Transactional
	public Estado buscarEstado( Long id) {
		
		return estadoRepository.findById(id).orElseThrow(()-> new EntidadeNaoExiste(
				String.format(MSG_ESTADO_NAO_ENCONTRADO+id)));
	}
	
	@Transactional
	public void deletarCidade( Long id) {
		
		try {
			
			cidadeRepository.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			throw new EntidadeNaoExiste(String.format (MSG_CIDADE_NAO_ENCONTRADA));
		
		} catch (DataIntegrityViolationException e) {
			
			throw new EntidadeComIntegracaoAoutra(String.format(MSG_CIDADE_NAO_PODE_SER_EXCLUIDA));
		}
	}
	
	@Transactional
	public Optional<Cidade> buscaCidadesId(Long id){
		
		return cidadeRepository.findById(id);
	}
	
}

















