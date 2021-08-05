package br.com.gulafood.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gulafood.model.Permissao;

public interface PermissaoRepository extends JpaRepository<Permissao, Long> {

}
