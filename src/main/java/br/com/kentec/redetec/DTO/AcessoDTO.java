package br.com.kentec.redetec.DTO;

import java.util.List;

public class AcessoDTO {
	
	private Long id;
	private String nome;
	private Boolean autenticacao;
	private List<String> descricao;
	
	public AcessoDTO () {
		
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

	public Boolean getAutenticacao() {
		return autenticacao;
	}

	public void setAutenticacao(Boolean autenticacao) {
		this.autenticacao = autenticacao;
	}

	public List<String> getDescricao() {
		return descricao;
	}

	public void setDescricao(List<String> descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "AcessoDTO [id=" + id + ", nome=" + nome + ", autenticacao=" + autenticacao + ", descricao=" + descricao
				+ "]";
	}
}
