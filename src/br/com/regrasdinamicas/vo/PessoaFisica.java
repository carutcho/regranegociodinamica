package br.com.regrasdinamicas.vo;

public class PessoaFisica extends Pessoa {

	String cpf;
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public String getDocumento() {
		return cpf;
	}

}
