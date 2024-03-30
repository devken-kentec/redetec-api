package br.com.kentec.redetec.domain;

public class Cep {
	
	private String cep;
	private String logradouro;
	private String complemento;
	private String bairro;
	private String localidade;
	private String uf;
	private String ibge;
	private String gia;
	private String ddd;
	private String siafi;

	public Cep() {
		
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	@Override
	public String toString() {
		return "Cep [cep=" + cep + ", logradouro=" + logradouro + ", complemento=" + complemento + ", bairro=" + bairro
				+ ", localidade=" + localidade + ", uf=" + uf + ", ibge=" + ibge + ", gia=" + gia + ", ddd=" + ddd
				+ ", siafi=" + siafi + "]";
	}
}
