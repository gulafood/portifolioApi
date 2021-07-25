package br.com.gulafood.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gulafood.model.Restaurante;

public interface RestauranteRepository extends JpaRepository<Restaurante, Long>{

}
