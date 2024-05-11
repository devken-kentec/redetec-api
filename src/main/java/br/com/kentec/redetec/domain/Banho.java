package br.com.kentec.redetec.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

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
	private LocalDateTime incio;
	
	@Column(name="status_banho_tosa", nullable = false)
	private String statusBanhoTosa;
	
	@Column(name="status", nullable = false)
	private String status;
	
	@Column(name="termino", nullable = false)
	private LocalDateTime termino;
	
	@Column(name="observacao", nullable = false, length = 256)
	private String observacao;
	
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

	public LocalDateTime getIncio() {
		return incio;
	}

	public void setIncio(LocalDateTime incio) {
		this.incio = incio;
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

	public LocalDateTime getTermino() {
		return termino;
	}

	public void setTermino(LocalDateTime termino) {
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

	@Override
	public String toString() {
		return "Banho [id=" + id + ", incio=" + incio + ", statusBanhoTosa=" + statusBanhoTosa + ", status=" + status
				+ ", termino=" + termino + ", observacao=" + observacao + ", animal=" + animal + ", tipoBanhoTosa="
				+ tipoBanhoTosa + "]";
	}
}
