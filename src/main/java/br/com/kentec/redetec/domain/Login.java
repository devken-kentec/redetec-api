package br.com.kentec.redetec.domain;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="login")
@SuppressWarnings("serial")
public class Login implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false, length = 11)
	private Long id;
	
	@Column(name="senha", nullable = true, length = 100)
	private String senha;
	
	@Column(name="status", nullable = true, length = 7)
	private String status;
	
	@Column(name="login", unique=true, nullable = true, length = 20)
	private String login;
	
	@Column(name="pin", unique=true, nullable = true, length = 4)
	private String pin;
	
	@ManyToOne
	@JoinColumn(name = "id_humano", nullable = true)
	private Humano humano = new Humano();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public Humano getHumano() {
		return humano;
	}

	public void setHumano(Humano humano) {
		this.humano = humano;
	}

	@Override
	public String toString() {
		return "Login [id=" + id + ", senha=" + senha + ", status=" + status + ", login=" + login + ", pin=" + pin
				+ ", humano=" + humano + "]";
	}	
}
