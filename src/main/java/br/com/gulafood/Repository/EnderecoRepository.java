package br.com.gulafood.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gulafood.model.Endereco;

public interface EnderecoRepository extends  JpaRepository<Endereco, Long>{

}
