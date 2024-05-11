package br.com.kentec.redetec.DTO;

import java.time.LocalDateTime;

import br.com.kentec.redetec.domain.Banho;

public class BanhoDTO {
	
	private Long id;
	private LocalDateTime inicio;
	private String statusBanhoTosa;
	private String status;
	private LocalDateTime termino;
	private String observacao;
	private Long animal;
	private Long tipoBanhoTosa;
	
	public BanhoDTO() {
		
	}
	
	public BanhoDTO(Banho banho) {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getInicio() {
		return inicio;
	}

	public void setInicio(LocalDateTime inicio) {
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

	public Long getAnimal() {
		return animal;
	}

	public void setAnimal(Long animal) {
		this.animal = animal;
	}

	public Long getTipoBanhoTosa() {
		return tipoBanhoTosa;
	}

	public void setTipoBanhoTosa(Long tipoBanhoTosa) {
		this.tipoBanhoTosa = tipoBanhoTosa;
	}
}
