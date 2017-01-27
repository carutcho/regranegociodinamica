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

	private static final String ENDERECO_EMPRESA = "comercial@empresa.com.br";
	
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
		PessoaFisica pessoaComException = new PessoaFisica("Reinaldo","213.213.123-1","reinaldo.torresrj@gmail.comm.br");
		
		pessoasEnviarEmailException.add(pessoaComException);
		
		try {
			enviarEmailCompras(pessoasEnviarEmailException);
		} catch (ServiceBusinessException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println("Falha interna, contacte um administrador");
		}
		
	}

	//TODO: transformar em RN
	private static void enviarEmailCompras(List<Pessoa> pessoasEnviarEmail) throws Exception {
		
		for (Pessoa pessoa : pessoasEnviarEmail) {
			Email emailEmpresa = new Email(ENDERECO_EMPRESA, pessoa.getEmail());
			
			EnviarEmail enviarEmail = new EnviarEmail(pessoa, emailEmpresa);			
			if (pessoa instanceof PessoaJuridica){
				System.out.println("\n --- REGRA DE PESSOA JURIDICA --- \n");
				enviarEmailPessoaJuridica(emailEmpresa, pessoa, enviarEmail);								
			}else{
				System.out.println("\n --- REGRA DE PESSOA FISICA --- \n");
				enviarEmailPessoaFisica(enviarEmail);
			}
		}
	}

	//TODO: transformar em RN
	private static void enviarEmailPessoaFisica(EnviarEmail enviarEmail) throws Exception {
		enviarEmail.executar();
	}

	//TODO: transformar em RN
	private static void enviarEmailPessoaJuridica(Email email, Pessoa pessoa, EnviarEmail enviarEmail) throws ServiceBusinessException, Exception {
		
		List<RegraDeNegocio> regrasEnvio = new ArrayList<RegraDeNegocio>();
		regrasEnvio.add(new AdicionarLink(email, "www.linkedin.com.br/reinaldo"));
		
		GerarNotaFiscal gerarNota = new GerarNotaFiscal(pessoa);
		Arquivo nota = (Arquivo) gerarNota.executarRetorno();
		
		regrasEnvio.add(new AnexarArquivoEmail(email, nota));
		enviarEmail.executar(regrasEnvio);
	}
		
}
