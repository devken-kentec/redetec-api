package br.com.kentec.redetec.DTO;

import br.com.kentec.redetec.domain.Acesso;

public class ConfigAcessoDTO {
	
	private Long id;
	private Long idNome;
	private String statusAcesso;
	private String statusLogin;
	private String descricao;
	private String senha;
	private String pin;
	private String login;
	private String nome;
	private String sobreNome;
	
	
	public ConfigAcessoDTO() {
		
	}
	
	public ConfigAcessoDTO(Acesso acesso) {
		this.id = acesso.getId();
		this.statusAcesso = acesso.getStatus();
		this.statusLogin = acesso.getLogin().getStatus();
		this.descricao = acesso.getDescricao();
		this.senha = acesso.getLogin().getSenha();
		this.pin = acesso.getLogin().getPin();
		this.login = acesso.getLogin().getLogin();
		this.nome = acesso.getLogin().getHumano().getNome();
		this.sobreNome = acesso.getLogin().getHumano().getSobrenome();
		this.idNome = acesso.getLogin().getHumano().getId();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatusAcesso() {
		return statusAcesso;
	}

	public void setStatusAcesso(String statusAcesso) {
		this.statusAcesso = statusAcesso;
	}

	public String getStatusLogin() {
		return statusLogin;
	}

	public void setStatusLogin(String statusLogin) {
		this.statusLogin = statusLogin;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobreNome() {
		return sobreNome;
	}

	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}

	public Long getIdNome() {
		return idNome;
	}

	public void setIdNome(Long idNome) {
		this.idNome = idNome;
	}
}
