package br.com.regrasdinamicas.vo;

import br.com.regrasdinamicas.enums.TipoMensagemEnum;

public class Mensagem {

	Documento documento;
	TipoMensagemEnum tipo;
	Object origem;
	Object destino;

	public Documento getDocumento() {
		return documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}

	public TipoMensagemEnum getTipo() {
		return tipo;
	}
	
	public void setTipo(TipoMensagemEnum tipo) {
		this.tipo = tipo;
	}
	
	public Object getOrigem() {
		return origem;
	}
	
	public void setOrigem(Object origem) {
		this.origem = origem;
	}
	
	public Object getDestino() {
		return destino;
	}
	
	public void setDestino(Object destino) {
		this.destino = destino;
	}
	
	
		
}
