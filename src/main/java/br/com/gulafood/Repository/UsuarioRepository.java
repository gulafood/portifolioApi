package br.com.gulafood.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.gulafood.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	

	@Query("SELECT pr FROM Usuario pr  JOIN FETCH pr.enderecosUsuario")
	List<Usuario> findUsuarioEnderecos(Long user);
	
	
	
	
}
