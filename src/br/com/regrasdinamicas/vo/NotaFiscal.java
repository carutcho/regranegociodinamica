package br.com.regrasdinamicas.vo;

public class NotaFiscal extends Documento {

	Pessoa remetente;

	public NotaFiscal(Pessoa remetente){
		this.remetente = remetente;
	}
	
	public Pessoa getRemetente() {
		return remetente;
	}

	public void setRemetente(Pessoa remetente) {
		this.remetente = remetente;
	}
	
	
}
