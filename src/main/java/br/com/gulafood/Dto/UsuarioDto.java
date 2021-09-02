package br.com.gulafood.Dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.gulafood.model.Usuario;

/**
 * 
 * 
 * @author winston
 *
 */
public class UsuarioDto {

	private Long id;
	private String nome;
	private String email;
	private String senha;
	private String telefone;
	private LocalDateTime dataCadastro;

	// lista de enderecos
	private List<EnderecoDto> enderecos = new ArrayList<>();

	public UsuarioDto() {
	}

	// conversao de produto para produtoDto copiando as enderecos fazendo uma
	// stream>map convertendo cada
	// elemento end para um enderecoDto ou seja apartir da lista de enderecos de
	// usuario eu estou produzindo uma
	// lista de endereçoDto para associar ao usuarioDto
	public UsuarioDto(Usuario usuario) {

		id = usuario.getId();
		nome = usuario.getNome();
		email = usuario.getEmail();
		senha = usuario.getSenha();
		telefone = usuario.getTelefone();
		dataCadastro = usuario.getDataCadastro();

		enderecos = usuario.getEnderecosUsuario().stream().map(end -> new EnderecoDto(end))
				.collect(Collectors.toList());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public List<EnderecoDto> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<EnderecoDto> enderecos) {
		this.enderecos = enderecos;
	}

}
