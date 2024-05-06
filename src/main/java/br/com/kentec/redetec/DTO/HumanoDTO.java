package br.com.kentec.redetec.DTO;

import br.com.kentec.redetec.domain.Humano;

public class HumanoDTO {
	private Long id;
	private String nome;
	private String sobrenome;
	private String dataNascimento;
	private String cep;
	private String endereco;
	private String complemento;
	private String fone;
	private String whatsapp;
	private String email;
	private String status;
	private Long empresa;
	
	public HumanoDTO() {
		
	}
	
	public HumanoDTO(Humano humano) {
		this.id = humano.getId();
		this.nome = humano.getNome();
		this.sobrenome = humano.getSobrenome();
		this.dataNascimento = humano.getDataNascimento();
		this.cep = humano.getCep();
		this.endereco = humano.getEndereco();
		this.complemento = humano.getComplemento();
		this.fone = humano.getFone();
		this.whatsapp = humano.getWhatsapp();
		this.email = humano.getEmail();
		this.status = humano.getStatus();
		this.empresa = humano.getEmpresa().getId();
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

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public String getWhatsapp() {
		return whatsapp;
	}

	public void setWhatsapp(String whatsapp) {
		this.whatsapp = whatsapp;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Long empresa) {
		this.empresa = empresa;
	}
}
