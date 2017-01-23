package br.com.regrasdinamicas.vo;

public class PessoaJuridica extends Pessoa{

	private String cnpj;

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	@Override
	public String getDocumento() {
		return cnpj;
	}

}
