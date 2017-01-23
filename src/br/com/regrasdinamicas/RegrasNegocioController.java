package br.com.regrasdinamicas;

import java.util.ArrayList;
import java.util.List;

import br.com.regrasdinamicas.exception.ServiceBusinessException;
import br.com.regrasdinamicas.interfaces.RegraDeNegocio;
import br.com.regrasdinamicas.regras.email.AdicionarLink;
import br.com.regrasdinamicas.regras.email.AnexarArquivoEmail;
import br.com.regrasdinamicas.regras.email.EnviarEmail;
import br.com.regrasdinamicas.regras.notafiscal.GerarNotaFiscal;
import br.com.regrasdinamicas.vo.Arquivo;
import br.com.regrasdinamicas.vo.Email;
import br.com.regrasdinamicas.vo.Pessoa;
import br.com.regrasdinamicas.vo.PessoaFisica;
import br.com.regrasdinamicas.vo.PessoaJuridica;

public class RegrasNegocioController {

	public static void main (String args[]){
	
		List<Pessoa> pessoasEnviarEmail = new ArrayList<Pessoa>();
		
		PessoaFisica pessoaFisica = new PessoaFisica();
		pessoaFisica.setNome("Reinaldo");
		pessoaFisica.setEmail("reinaldo.torresrj@gmail.com.br");
		pessoaFisica.setEndereco("Blumenau");
		pessoaFisica.setCpf("213.213.123-1");
		pessoasEnviarEmail.add(pessoaFisica);
		
		PessoaJuridica pessoaJuridica = new PessoaJuridica();
		pessoaJuridica.setNome("Empresa");
		pessoaJuridica.setEmail("financeiro@empresa.comm.br");
		pessoaJuridica.setEndereco("Blumenau");
		pessoaJuridica.setCnpj("56.379.114/0001-49");
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
		PessoaFisica pessoaComException = new PessoaFisica();
		pessoaComException.setNome("Reinaldo");
		
		pessoasEnviarEmailException.add(pessoaComException);
		
		try {
			enviarEmailCompras(pessoasEnviarEmailException);
		} catch (ServiceBusinessException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println("Falha interna, contacte um administrador");
		}
		
	}

	private static void enviarEmailCompras(List<Pessoa> pessoasEnviarEmail) throws Exception {
		
		Email email = new Email();
		email.setEnderecoOrigem("reinaldo.torresrj@gmail.com.br");
		
		for (Pessoa pessoa : pessoasEnviarEmail) {
			
			EnviarEmail enviarEmail = new EnviarEmail(pessoa, email);			
			if (pessoa instanceof PessoaJuridica){
				System.out.println("\n --- REGRA DE PESSOA JURIDICA --- \n");
				enviarEmailPessoaJuridica(email, pessoa, enviarEmail);								
			}else{
				System.out.println("\n --- REGRA DE PESSOA FISICA --- \n");
				enviarEmail.executar();	//Enviando email simples
			}
		}
	}

	private static void enviarEmailPessoaJuridica(Email email, Pessoa pessoa, EnviarEmail enviarEmail) throws ServiceBusinessException, Exception {
		
		List<RegraDeNegocio> regrasEnvio = new ArrayList<RegraDeNegocio>();
		regrasEnvio.add(new AdicionarLink(email, "www.linkedin.com.br/reinaldo"));
		
		GerarNotaFiscal gerarNota = new GerarNotaFiscal(pessoa);
		Arquivo nota = (Arquivo) gerarNota.executarRetornoSimples();
		
		regrasEnvio.add(new AnexarArquivoEmail(email, nota));
		enviarEmail.executar(regrasEnvio);
	}
	
	
}
