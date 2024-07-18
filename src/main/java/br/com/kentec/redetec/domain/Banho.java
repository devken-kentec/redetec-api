package br.com.kentec.redetec.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="banho")
@SuppressWarnings("serial")
public class Banho implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false, length = 11)
	private Long id;
	
	@Column(name="inicio", nullable = false)
	private String inicio;
	
	@Column(name="status_banho_tosa", nullable = false)
	private String statusBanhoTosa;
	
	@Column(name="status_pagamento_banho", nullable = true,  length = 32)
	private String statusPagamentoBanho;
	
	@Column(name="transporte", nullable = true, precision = 10, scale = 2)
	private BigDecimal transporte;
	
	@Column(name="desconto", nullable = true, precision = 10, scale = 2)
	private BigDecimal desconto;
	
	@Column(name="status", nullable = false)
	private String status;
	
	@Column(name="termino", nullable = false)
	private String termino;
	
	@Column(name="observacao", nullable = false, length = 256)
	private String observacao;
	
	@Column(name="buscar", nullable = true)
	private Boolean buscar;
	
	@Column(name="entregar", nullable = true)
	private Boolean entregar;
	
	@ManyToOne
	@JoinColumn(name = "id_animal", nullable = true)
	Animal animal = new Animal();
	
	@ManyToOne
	@JoinColumn(name = "id_tipo_banho_tosa", nullable = true)
	TipoBanhoTosa tipoBanhoTosa = new TipoBanhoTosa();
	
	public Banho() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getInicio() {
		return inicio;
	}

	public void setInicio(String inicio) {
		this.inicio = inicio;
	}

	public String getStatusBanhoTosa() {
		return statusBanhoTosa;
	}

	public void setStatusBanhoTosa(String statusBanhoTosa) {
		this.statusBanhoTosa = statusBanhoTosa;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTermino() {
		return termino;
	}

	public void setTermino(String termino) {
		this.termino = termino;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public TipoBanhoTosa getTipoBanhoTosa() {
		return tipoBanhoTosa;
	}

	public void setTipoBanhoTosa(TipoBanhoTosa tipoBanhoTosa) {
		this.tipoBanhoTosa = tipoBanhoTosa;
	}

	public String getStatusPagamentoBanho() {
		return statusPagamentoBanho;
	}

	public void setStatusPagamentoBanho(String statusPagamentoBanho) {
		this.statusPagamentoBanho = statusPagamentoBanho;
	}

	public BigDecimal getTransporte() {
		return transporte;
	}

	public void setTransporte(BigDecimal transporte) {
		this.transporte = transporte;
	}

	public Boolean getBuscar() {
		return buscar;
	}

	public void setBuscar(Boolean buscar) {
		this.buscar = buscar;
	}

	public Boolean getEntregar() {
		return entregar;
	}

	public void setEntregar(Boolean entregar) {
		this.entregar = entregar;
	}

	public BigDecimal getDesconto() {
		return desconto;
	}

	public void setDesconto(BigDecimal desconto) {
		this.desconto = desconto;
	}

	@Override
	public String toString() {
		return "Banho [id=" + id + ", inicio=" + inicio + ", statusBanhoTosa=" + statusBanhoTosa
				+ ", statusPagamentoBanho=" + statusPagamentoBanho + ", transporte=" + transporte + ", desconto="
				+ desconto + ", status=" + status + ", termino=" + termino + ", observacao=" + observacao + ", buscar="
				+ buscar + ", entregar=" + entregar + ", animal=" + animal + ", tipoBanhoTosa=" + tipoBanhoTosa + "]";
	}
}
