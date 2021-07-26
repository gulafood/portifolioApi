package br.com.gulafood.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.gulafood.Repository.RestauranteRepository;

@Controller
@RequestMapping
public class RestauranteController {
	@Autowired
	private  RestauranteRepository restauranteRepository;
	
}
