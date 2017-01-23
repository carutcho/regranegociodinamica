package br.com.regrasdinamicas.vo;

import br.com.regrasdinamicas.enums.TipoArquivoEnum;

public class Arquivo {

	String caminho;
	String nome;
	TipoArquivoEnum tipo;
	
	public String getCaminho() {
		return caminho;
	}
	
	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public TipoArquivoEnum getTipo() {
		return tipo;
	}
	
	public void setTipo(TipoArquivoEnum tipo) {
		this.tipo = tipo;
	}
	
}
