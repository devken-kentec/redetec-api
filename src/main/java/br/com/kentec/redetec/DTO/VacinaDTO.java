package br.com.kentec.redetec.DTO;

import java.math.BigDecimal;

import br.com.kentec.redetec.domain.Vacina;

public class VacinaDTO {
	private Long id;
	private String dataVacinacao;
	private String dataRetorno;
	private String statusPagamento;
	private String referencia;
	private String obervacao;
	private Long vacina;
	private String descricaoVacina;
	private BigDecimal valorVacina;
	private Long animal;
	private String descricaoAnimal;
	private String humanoAnimal;
	
	public VacinaDTO() {
		
	}
	
	public VacinaDTO(Vacina vacina) {
		
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

	public String getDataRetorno() {
		return dataRetorno;
	}

	public void setDataRetorno(String dataRetorno) {
		this.dataRetorno = dataRetorno;
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

	public String getObervacao() {
		return obervacao;
	}

	public void setObervacao(String obervacao) {
		this.obervacao = obervacao;
	}

	public Long getVacina() {
		return vacina;
	}

	public void setVacina(Long vacina) {
		this.vacina = vacina;
	}

	public String getDescricaoVacina() {
		return descricaoVacina;
	}

	public void setDescricaoVacina(String descricaoVacina) {
		this.descricaoVacina = descricaoVacina;
	}

	public BigDecimal getValorVacina() {
		return valorVacina;
	}

	public void setValorVacina(BigDecimal valorVacina) {
		this.valorVacina = valorVacina;
	}

	public Long getAnimal() {
		return animal;
	}

	public void setAnimal(Long animal) {
		this.animal = animal;
	}

	public String getDescricaoAnimal() {
		return descricaoAnimal;
	}

	public void setDescricaoAnimal(String descricaoAnimal) {
		this.descricaoAnimal = descricaoAnimal;
	}

	public String getHumanoAnimal() {
		return humanoAnimal;
	}

	public void setHumanoAnimal(String humanoAnimal) {
		this.humanoAnimal = humanoAnimal;
	}
}
