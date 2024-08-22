package br.com.kentec.redetec.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="humano")
@SuppressWarnings("serial")
public class Humano implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false, length = 11)
	private Long id;
	
	@Column(name="nome", nullable = false, length = 50)
	private String nome;
	
	@Column(name="sobrenome", nullable = true, length = 50)
	private String sobrenome;
	
	@Column(name="data_nascimento", nullable = true, length = 10)
	@JsonFormat(pattern="yyyy-MM-dd")
	private String dataNascimento;
	
	@Column(name="cep", nullable = true, length = 8)
	private String cep;
	
	@Column(name="endereco", nullable = true, length = 256)
	private String endereco;
	
	@Column(name="complemento", nullable = true, length = 128)
	private String complemento;
	
	@Column(name="fone", nullable = true, length = 20)
	private String fone;
	
	@Column(name="whatsapp", nullable = true, length = 20)
	private String whatsapp;
	
	@Column(name="email", unique=true, nullable = true, length = 60)
	private String email;
	
	@Column(name="status", nullable = true, length = 7)
	private String status;
	
	@ManyToOne
	@JoinColumn(name = "id_empresa", nullable = true)
	private Empresa empresa = new Empresa();
	

	public Humano() {
	
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

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	@Override
	public String toString() {
		return "Humano [id=" + id + ", nome=" + nome + ", sobrenome=" + sobrenome + ", dataNascimento=" + dataNascimento
				+ ", cep=" + cep + ", endereco=" + endereco + ", complemento=" + complemento + ", fone=" + fone
				+ ", whatsapp=" + whatsapp + ", email=" + email + ", status=" + status + ", empresa=" + empresa + "]";
	}
}	

