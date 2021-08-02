package br.com.gulafood.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gulafood.model.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {

}
