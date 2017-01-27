package br.com.regrasdinamicas.vo;

public class PessoaFisica extends Pessoa {

	String cpf;
	
	public PessoaFisica(String nome, String cpf, String email){
		super.setNome(nome);
		super.setEmail(email);
		this.setCpf(cpf);		
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public String getDocumento() {
		return cpf;
	}

}
