package br.com.gulafood.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gulafood.model.Restaurante;
@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, Long>{

}
