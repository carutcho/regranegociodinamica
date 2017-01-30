package br.com.regrasdinamicas.controller;

import java.util.List;

import br.com.regrasdinamicas.regras.notafiscal.EnviarEmailComprasPessoaFisica;
import br.com.regrasdinamicas.regras.notafiscal.EnviarEmailComprasPessoaJuridica;
import br.com.regrasdinamicas.vo.Pessoa;
import br.com.regrasdinamicas.vo.PessoaJuridica;

public class NotaFiscalServiceImpl implements NotaFiscalService{

	private final String ENDERECO_EMAIL_EMPRESA = "comercial@empresa.com.br";
	
	public void enviarEmailCompras(List<Pessoa> pessoasEnviarEmail) throws Exception {
		
		for (Pessoa pessoa : pessoasEnviarEmail) {
			
			if (pessoa instanceof PessoaJuridica){
				System.out.println("\n --- REGRA DE PESSOA JURIDICA --- \n");
				EnviarEmailComprasPessoaJuridica enviarEmail = new EnviarEmailComprasPessoaJuridica(pessoa, ENDERECO_EMAIL_EMPRESA);
				enviarEmail.executar();
			}else{
				System.out.println("\n --- REGRA DE PESSOA FISICA --- \n");
				EnviarEmailComprasPessoaFisica enviarEmail = new EnviarEmailComprasPessoaFisica(pessoa, ENDERECO_EMAIL_EMPRESA);
				enviarEmail.executar();
			}
		}
	}


		
}
