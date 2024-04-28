package br.com.kentec.redetec.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="animal")
@SuppressWarnings("serial")
public class Animal implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false, length = 11)
	private Long id;
	
	@Column(name="nome", nullable = false, length = 50)
	private String nome;
	
	@Column(name="data_nascimento", nullable = true, length = 10)
	@JsonFormat(pattern="yyyy-MM-dd")
	private String dataNascimento;
	
	@Column(name="cor", nullable = true, length = 24)
	private String cor;
	
	@Column(name="especie", nullable = true, length = 24)
	private String especie;
	
	@Column(name="peso", nullable = true, precision = 6, scale = 3)
	private BigDecimal peso;
	
	@Column(name="sexo", nullable = true, length = 10)
	private String sexo;
	
	@Column
	@Lob
	public byte[] foto;
	
	@Column(name="observacao", nullable = true, length = 256)
	private String observacao;
	
	@ManyToOne
	@JoinColumn(name = "id_raca", nullable = true)
	private Raca raca = new Raca();
	
	@ManyToOne
	@JoinColumn(name = "id_humano", nullable = true)
	private Humano humano = new Humano();
	
	@ManyToOne
	@JoinColumn(name = "id_empresa", nullable = true)
	private Empresa empresa = new Empresa();
	
	@Column(name="status", nullable = true, length = 7)
	private String status;

	public Animal() {
		
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

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Raca getRaca() {
		return raca;
	}

	public void setRaca(Raca raca) {
		this.raca = raca;
	}

	public Humano getHumano() {
		return humano;
	}

	public void setHumano(Humano humano) {
		this.humano = humano;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Animal [id=" + id + ", nome=" + nome + ", dataNascimento=" + dataNascimento + ", cor=" + cor
				+ ", especie=" + especie + ", peso=" + peso + ", sexo=" + sexo + ", foto=" + Arrays.toString(foto)
				+ ", observacao=" + observacao + ", raca=" + raca + ", humano=" + humano + ", empresa=" + empresa
				+ ", status=" + status + "]";
	}
	
	
}
