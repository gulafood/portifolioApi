package br.com.gulafood.model;

import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class FotoProdutoFile {
	
	@NotNull
	private MultipartFile foto;

}
