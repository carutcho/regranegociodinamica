package br.com.regrasdinamicas.vo;

import java.util.List;

import br.com.regrasdinamicas.enums.TipoMensagemEnum;

public class Email extends Mensagem {

	private List<Arquivo> anexo;
	private String link;	

	public Email(String enderecoOrigem, String enderedoDestino){
		super.setOrigem(enderecoOrigem);
		super.setDestino(enderedoDestino);
		super.setTipo(TipoMensagemEnum.EMAIL);
	}

	public List<?> getAnexo() {
		return anexo;
	}

	public void setAnexo(List<Arquivo> anexo) {
		this.anexo = anexo;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

}
