package br.com.kentec.redetec.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.kentec.redetec.enuns.StatusBanho;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="banho_tosa")
@SuppressWarnings("serial")
public class BanhoTosa implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false, length = 11)
	private Long id;
	
	@Column(name="data", nullable = true, length = 10)
	@JsonFormat(pattern="yyyy-MM-dd")
	private String data;
	
	@Column(name="hora_chegada", nullable = true, length = 5)
	private String horaChegada;
	
	@Column(name="hora_termino", nullable = true, length = 5)
	private String horaTermino;
	
	@Column(name="status_banho", nullable = true)
	@Enumerated(EnumType.STRING)
	private StatusBanho statusBanho;
	
	@Column(name="status_pagamento", nullable = true, length = 10)
	private String statusPagamento;
	
	@Column(name="status", nullable = true, length = 7)
	private String status;
	
	@Column(name="observacao", nullable = true, length = 256)
	private String observacao;
	
	@ManyToOne
	@JoinColumn(name = "id_tipo_banho_tosa", nullable = false)
	private TipoBanhoTosa tipoTosaBanho = new TipoBanhoTosa();
	
	@ManyToOne
	@JoinColumn(name = "id_animal", nullable = false)
	private Animal animal = new Animal();
	
	public BanhoTosa() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHoraChegada() {
		return horaChegada;
	}

	public void setHoraChegada(String horaChegada) {
		this.horaChegada = horaChegada;
	}

	public String getHoraTermino() {
		return horaTermino;
	}

	public void setHoraTermino(String horaTermino) {
		this.horaTermino = horaTermino;
	}

	public StatusBanho getStatusBanho() {
		return statusBanho;
	}

	public void setStatusBanho(StatusBanho statusBanho) {
		this.statusBanho = statusBanho;
	}

	public String getStatusPagamento() {
		return statusPagamento;
	}

	public void setStatusPagamento(String statusPagamento) {
		this.statusPagamento = statusPagamento;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public TipoBanhoTosa getTipoTosaBanho() {
		return tipoTosaBanho;
	}

	public void setTipoTosaBanho(TipoBanhoTosa tipoTosaBanho) {
		this.tipoTosaBanho = tipoTosaBanho;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	@Override
	public String toString() {
		return "BanhoTosa [id=" + id + ", data=" + data + ", horaChegada=" + horaChegada + ", horaTermino="
				+ horaTermino + ", statusBanho=" + statusBanho + ", statusPagamento=" + statusPagamento + ", status="
				+ status + ", observacao=" + observacao + ", tipoTosaBanho=" + tipoTosaBanho + ", animal=" + animal
				+ "]";
	}
}
