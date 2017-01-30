package br.com.regrasdinamicas;

import java.util.ArrayList;
import java.util.List;

import br.com.regrasdinamicas.exception.ServiceBusinessException;
import br.com.regrasdinamicas.regras.notafiscal.EnviarEmailComprasPessoaFisica;
import br.com.regrasdinamicas.regras.notafiscal.EnviarEmailComprasPessoaJuridica;
import br.com.regrasdinamicas.vo.Pessoa;
import br.com.regrasdinamicas.vo.PessoaFisica;
import br.com.regrasdinamicas.vo.PessoaJuridica;

public class RegrasNegocioController {

	private static final String ENDERECO_EMAIL_EMPRESA = "comercial@empresa.com.br";
	
	public static void main (String args[]){
	
		List<Pessoa> pessoasEnviarEmail = new ArrayList<Pessoa>();
		
		PessoaFisica pessoaFisica = new PessoaFisica("Reinaldo","213.213.123-1","reinaldo.torresrj@gmail.com.br");
		pessoaFisica.setEndereco("Blumenau");
		pessoasEnviarEmail.add(pessoaFisica);
		
		PessoaJuridica pessoaJuridica = new PessoaJuridica("Empresa","56.379.114/0001-49","financeiro@empresa.comm.br");
		pessoaJuridica.setEndereco("Blumenau");
		pessoasEnviarEmail.add(pessoaJuridica);
		
		try {
			enviarEmailCompras(pessoasEnviarEmail);
		} catch (ServiceBusinessException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println("Falha interna, contacte um administrador");
		}	
		
		
		// TESTE da regra estourando uma excessão de negócio
		
		System.out.println("\n\n\n  -------------- REGRA DE NEGOCIO COM ERRO ---------------- \n\n");
		
		List<Pessoa> pessoasEnviarEmailException = new ArrayList<Pessoa>();
		PessoaFisica pessoaComException = new PessoaFisica("Reinaldo","213.213.123-1",null);
		
		pessoasEnviarEmailException.add(pessoaComException);
		
		try {
			enviarEmailCompras(pessoasEnviarEmailException);
		} catch (ServiceBusinessException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println("Falha interna, contacte um administrador");
		}
		
	}

	//INTERFACE DO SERVICO
	public static void enviarEmailCompras(List<Pessoa> pessoasEnviarEmail) throws Exception {
		
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
