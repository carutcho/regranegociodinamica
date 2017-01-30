package br.com.regrasdinamicas.main;

import java.util.ArrayList;
import java.util.List;

import br.com.regrasdinamicas.controller.NotaFiscalService;
import br.com.regrasdinamicas.controller.NotaFiscalServiceImpl;
import br.com.regrasdinamicas.exception.ServiceBusinessException;
import br.com.regrasdinamicas.vo.Pessoa;
import br.com.regrasdinamicas.vo.PessoaFisica;
import br.com.regrasdinamicas.vo.PessoaJuridica;

public class Main {
	
	public static void main (String args[]){
		
		NotaFiscalService controleNf = new NotaFiscalServiceImpl();		
		//sucesso
		testarRegraSucesso(controleNf);	
				
		// Regra com exceção		
		testarRegraComErro(controleNf);		
	}

	private static void testarRegraComErro(NotaFiscalService controleNf) {
		
		System.out.println("\n\n\n  -------------- REGRA DE NEGOCIO COM ERRO ---------------- \n\n");		
		List<Pessoa> pessoasEnviarEmailException = new ArrayList<Pessoa>();
		PessoaFisica pessoaComException = new PessoaFisica("Reinaldo","213.213.123-1",null);
		
		pessoasEnviarEmailException.add(pessoaComException);
		
		try {
			controleNf.enviarEmailCompras(pessoasEnviarEmailException);
		} catch (ServiceBusinessException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println("Falha interna, contacte um administrador");
		}
	}

	private static void testarRegraSucesso(NotaFiscalService controleNf) {
		
		System.out.println("\n\n\n  -------------- REGRA DE NEGOCIO COM SUCESSO ---------------- \n\n");		
		List<Pessoa> pessoasEnviarEmail = new ArrayList<Pessoa>();
		PessoaFisica pessoaFisica = new PessoaFisica("Reinaldo","213.213.123-1","reinaldo.torresrj@gmail.com.br");
		pessoaFisica.setEndereco("Blumenau");
		pessoasEnviarEmail.add(pessoaFisica);
		
		PessoaJuridica pessoaJuridica = new PessoaJuridica("Empresa","56.379.114/0001-49","financeiro@empresa.comm.br");
		pessoaJuridica.setEndereco("Blumenau");
		pessoasEnviarEmail.add(pessoaJuridica);
		
		try {
			controleNf.enviarEmailCompras(pessoasEnviarEmail);
		} catch (ServiceBusinessException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println("Falha interna, contacte um administrador");
		}
	}
}
