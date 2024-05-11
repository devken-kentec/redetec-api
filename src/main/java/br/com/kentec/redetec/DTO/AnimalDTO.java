package br.com.kentec.redetec.DTO;

import java.math.BigDecimal;

import br.com.kentec.redetec.domain.Animal;

public class AnimalDTO {
	private Long id;
	private String nome;
	private String dataNascimento;
	private String cor;
	private String porte;
	private String especie;
	private BigDecimal peso;
	private String sexo;
	private String  foto;
	private String observacao;
	private Long  raca;
	private Long humano;
	private Long empresa;
	private String status;
	private String humanoCompleto;
	private String contatoFone;
	private String contatoZap;
	
	public AnimalDTO() {
		
	}
	
	public AnimalDTO(Animal animal) {
		this.id = animal.getId();
		this.nome = animal.getNome();
		this.humanoCompleto = animal.getHumano().getNome() + animal.getHumano().getSobrenome(); 
		this.contatoFone =  animal.getHumano().getFone();
		this.contatoZap =  animal.getHumano().getWhatsapp();
		this.dataNascimento = animal.getDataNascimento();
		this.cor = animal.getCor();
		this.porte = animal.getPorte();
		this.especie = animal.getEspecie();
		this.peso = animal.getPeso();
		this.sexo = animal.getSexo();
		this.observacao = animal.getObservacao();
		this.raca = animal.getRaca().getId();
		this.humano = animal.getHumano().getId();
		this.empresa = animal.getEmpresa().getId();
		this.status = animal.getStatus();
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

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getPorte() {
		return porte;
	}

	public void setPorte(String porte) {
		this.porte = porte;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public BigDecimal getPeso() {
		return peso;
	}

	public void setPeso(BigDecimal peso) {
		this.peso = peso;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Long getRaca() {
		return raca;
	}

	public void setRaca(Long raca) {
		this.raca = raca;
	}

	public Long getHumano() {
		return humano;
	}

	public void setHumano(Long humano) {
		this.humano = humano;
	}

	public Long getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Long empresa) {
		this.empresa = empresa;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getHumanoCompleto() {
		return humanoCompleto;
	}

	public void setHumanoCompleto(String humanoCompleto) {
		this.humanoCompleto = humanoCompleto;
	}

	public String getContatoFone() {
		return contatoFone;
	}

	public void setContatoFone(String contatoFone) {
		this.contatoFone = contatoFone;
	}

	public String getContatoZap() {
		return contatoZap;
	}

	public void setContatoZap(String contatoZap) {
		this.contatoZap = contatoZap;
	}
}
