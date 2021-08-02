package br.com.gulafood.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gulafood.Repository.UsuarioRepository;
import br.com.gulafood.model.Usuario;

@Service
public class UsuarioServicos {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Transactional
	public Optional<Usuario> buscarUsuario (Long usuario){
		
		return usuarioRepository.findById(usuario);
	}
	

	@Transactional
	public List<Usuario> todosUsuario(){
		
		return usuarioRepository.findAll();
	}
	
	@Transactional
	public Usuario salvarUsuario( Usuario usuario) {
		
		return usuarioRepository.save(usuario);
	}
	
	@Transactional
	public void deletarUsuario(Usuario usuario) {
		
		usuarioRepository.delete(usuario);
	}
	
	
	
	// fazendo 
	public static boolean acessoUsuario(Usuario acesso , String liberacao) {

		return acesso.getSenha() == liberacao;
	}
	
}










