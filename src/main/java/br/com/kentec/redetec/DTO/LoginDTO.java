package br.com.kentec.redetec.DTO;

public class LoginDTO {
	
	private String email;
	private String senha;
	private String novaSenha;
	
	public LoginDTO() {
		
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNovaSenha() {
		return novaSenha;
	}

	public void setNovaSenha(String novaSenha) {
		this.novaSenha = novaSenha;
	}

	@Override
	public String toString() {
		return "LoginDTO [email=" + email + ", senha=" + senha + "]";
	}
}
