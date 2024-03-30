package br.com.kentec.redetec.domain;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="empresa")
@SuppressWarnings("serial")
public class Empresa implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false, length = 11)
	private Long id;
	
	@Column(name="nome_fantasia", nullable = true, length = 100)
	private String nomeFantasia;
	
	@Column(name="cep", nullable = true, length = 8)
	private String cep;
	
	@Column(name="endereco", nullable = true, length = 256)
	private String endereco;
	
	@Column(name="ramo_atividade", nullable = true, length = 50)
	private String ramoDeAtividade;
	
	@Column(name="telefone", nullable = true, length = 20)
	private String telefone;
	
	@Column(name="whatsapp", nullable = true, length = 20)
	private String whatsapp;
	
	public Empresa() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
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

	public String getRamoDeAtividade() {
		return ramoDeAtividade;
	}

	public void setRamoDeAtividade(String ramoDeAtividade) {
		this.ramoDeAtividade = ramoDeAtividade;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getWhatsapp() {
		return whatsapp;
	}

	public void setWhatsapp(String whatsapp) {
		this.whatsapp = whatsapp;
	}

	@Override
	public String toString() {
		return "Empresa [id=" + id + ", nomeFantasia=" + nomeFantasia + ", cep=" + cep + ", endereco=" + endereco
				+ ", ramoDeAtividade=" + ramoDeAtividade + ", telefone=" + telefone + ", whatsapp=" + whatsapp + "]";
	}
}
