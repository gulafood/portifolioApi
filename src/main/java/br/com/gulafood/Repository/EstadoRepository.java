package br.com.gulafood.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gulafood.model.Estado;

public interface EstadoRepository extends JpaRepository<Estado , Long> {

}
