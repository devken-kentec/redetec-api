package br.com.kentec.redetec.DTO;

public class PaginationDTO<T> {
	private T objeto;
	private Integer tamanho;
	private Integer Ultimo;
	private Integer TotalElementos;
	private Integer paginas;
	


	public PaginationDTO() {
	}

	public T getObjeto() {
		return objeto;
	}

	public void setObjeto(T objeto) {
		this.objeto = objeto;
	}

	public Integer getTamanho() {
		return tamanho;
	}

	public void setTamanho(Integer tamanho) {
		this.tamanho = tamanho;
	}

	public Integer getUltimo() {
		return Ultimo;
	}

	public void setUltimo(Integer ultimo) {
		Ultimo = ultimo;
	}

	public Integer getTotalElementos() {
		return TotalElementos;
	}

	public void setTotalElementos(Integer totalElementos) {
		TotalElementos = totalElementos;
	}

	public Integer getPaginas() {
		return paginas;
	}

	public void setPaginas(Integer paginas) {
		this.paginas = paginas;
	}

	@Override
	public String toString() {
		return "PaginationDTO [objeto=" + objeto + ", tamanho=" + tamanho + ", Ultimo=" + Ultimo + ", TotalElementos="
				+ TotalElementos + ", paginas=" + paginas + "]";
	}
}
