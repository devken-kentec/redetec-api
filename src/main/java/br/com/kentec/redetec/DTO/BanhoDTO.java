package br.com.kentec.redetec.DTO;

import java.math.BigDecimal;
import br.com.kentec.redetec.domain.Banho;

public class BanhoDTO {
	
	private Long id;
	private String inicio;
	private String statusBanhoTosa;
	private String status;
	private String termino;
	private String observacao;
	private Long animal;
	private String animalNome;
	private String animalHumano;
	private Long tipoBanhoTosa;
	private String tipoBanhoDescricao;
	private BigDecimal tipoBanhoValor;

	public BanhoDTO() {
		
	}
	
	public BanhoDTO(Banho banho) {
		this.id = banho.getId();
		this.inicio = banho.getIncio();
		this.statusBanhoTosa = banho.getStatusBanhoTosa();
		this.status = banho.getStatus();
		this.termino = banho.getTermino();
		this.observacao = banho.getObservacao();
		this.animal = banho.getAnimal().getId();
		this.animalNome = banho.getAnimal().getNome();
		this.animalHumano = banho.getAnimal().getHumano().getNome() + banho.getAnimal().getHumano().getSobrenome();
		this.tipoBanhoTosa = banho.getTipoBanhoTosa().getId();
		this.tipoBanhoDescricao = banho.getTipoBanhoTosa().getDescricao();
		this.tipoBanhoValor = banho.getTipoBanhoTosa().getValor();
	}

	public String getAnimalNome() {
		return animalNome;
	}

	public void setAnimalNome(String animalNome) {
		this.animalNome = animalNome;
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
    
	public String getAnimalHumano() {
		return animalHumano;
	}

	public void setAnimalHumano(String animalHumano) {
		this.animalHumano = animalHumano;
	}

	public BigDecimal getTipoBanhoValor() {
		return tipoBanhoValor;
	}

	public void setTipoBanhoValor(BigDecimal tipoBanhoValor) {
		this.tipoBanhoValor = tipoBanhoValor;
	}

	public String getTipoBanhoDescricao() {
		return tipoBanhoDescricao;
	}

	public void setTipoBanhoDescricao(String tipoBanhoDescricao) {
		this.tipoBanhoDescricao = tipoBanhoDescricao;
	}
}
