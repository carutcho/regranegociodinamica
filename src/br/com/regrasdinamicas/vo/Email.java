package br.com.regrasdinamicas.vo;

public class Email {

	String enderecoOrigem;
	String enderedoDestino;
	Arquivo anexo;
	String link;

	public Arquivo getAnexo() {
		return anexo;
	}

	public void setAnexo(Arquivo anexo) {
		this.anexo = anexo;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getEnderecoDestino() {
		return enderedoDestino;
	}

	public void setEnderedoDestino(String enderedoDestino) {
		this.enderedoDestino = enderedoDestino;
	}

	public String getEnderecoOrigem() {
		return enderecoOrigem;
	}

	public void setEnderecoOrigem(String enderecoOrigem) {
		this.enderecoOrigem = enderecoOrigem;
	}

}
