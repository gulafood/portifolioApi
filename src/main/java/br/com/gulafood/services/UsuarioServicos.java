package br.com.gulafood.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gulafood.Dto.UsuarioDto;
import br.com.gulafood.Repository.UsuarioRepository;
import br.com.gulafood.model.Usuario;

@Service
public class UsuarioServicos {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Transactional
	public Optional<Usuario> buscarUsuario(Long usuario) {

		return usuarioRepository.findById(usuario);
	}

	// leva uma lista de usuarios contendo seus dados como os dados pessoal nome
	// email e telefoen e uma lista de enderecos
	@Transactional
	public List<UsuarioDto> buscarDto(Long user) {

		List<Usuario> us = usuarioRepository.findUsuarioEnderecos(user);

		return us.stream().map(x -> new UsuarioDto(x)).collect(Collectors.toList());
	}

	@Transactional
	public List<Usuario> todosUsuario() {

		return usuarioRepository.findAll();
	}

	@Transactional
	public Usuario salvarUsuario(Usuario usuario) {

		return usuarioRepository.save(usuario);
	}

	@Transactional
	public void deletarUsuario(Usuario usuario) {

		usuarioRepository.delete(usuario);
	}

	@Transactional // confere se a senha esta com todos os caracteres e retorna um true ou false
	public static boolean existe(Usuario usuario) {

		boolean sizeSenha = false;
		sizeSenha = usuario.getSenha().length() == 6;
		return sizeSenha ;

	}

	// fazendo
	public static boolean acessoUsuario(Usuario acesso, String liberacao) {

		return acesso.getSenha() == liberacao;
	}

}
