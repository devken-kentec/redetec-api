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
@Table(name="vacina")
@SuppressWarnings("serial")
public class Vacina implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false, length = 11)
	private Long id;
	
	@Column(name="data_vacinacao", nullable = true, length = 10)
	@JsonFormat(pattern="yyyy-MM-dd")
	private String dataVacinacao;
	
	@Column(name="data_retorno", nullable = true, length = 10)
	@JsonFormat(pattern="yyyy-MM-dd")
	private String dataRetorno;
	
	@Column(name="status_pagamento", nullable = true, length = 10)
	private String statusPagamento;
	
	@Column(name="referencia", nullable = true, length = 100)
	private String referencia;
	
	@Column(name="observacao", nullable = true, length = 256)
	private String observacao;
	
	@ManyToOne
	@JoinColumn(name = "id_vacina", nullable = false)
	private TipoVacina tipoVacina = new TipoVacina();
	
	@ManyToOne
	@JoinColumn(name = "id_animal", nullable = false)
	private Animal animal = new Animal();
	
	@Column(name="status", nullable = true, length = 7)
	private String status;
	
	public Vacina() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDataVacinacao() {
		return dataVacinacao;
	}

	public void setDataVacinacao(String dataVacinacao) {
		this.dataVacinacao = dataVacinacao;
	}

	public String getStatusPagamento() {
		return statusPagamento;
	}

	public void setStatusPagamento(String statusPagamento) {
		this.statusPagamento = statusPagamento;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public TipoVacina getTipoVacina() {
		return tipoVacina;
	}

	public void setTipoVacina(TipoVacina tipoVacina) {
		this.tipoVacina = tipoVacina;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDataRetorno() {
		return dataRetorno;
	}

	public void setDataRetorno(String dataRetorno) {
		this.dataRetorno = dataRetorno;
	}

	@Override
	public String toString() {
		return "Vacina [id=" + id + ", dataVacinacao=" + dataVacinacao + ", dataRetorno=" + dataRetorno
				+ ", statusPagamento=" + statusPagamento + ", referencia=" + referencia + ", observacao=" + observacao
				+ ", tipoVacina=" + tipoVacina + ", animal=" + animal + ", status=" + status + "]";
	}
}
