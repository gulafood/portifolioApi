package br.com.gulafood.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gulafood.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	

}
