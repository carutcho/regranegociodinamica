package br.com.regrasdinamicas.regras.notafiscal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import br.com.regrasdinamicas.interfaces.RegraDeNegocio;
import br.com.regrasdinamicas.regras.email.AdicionarLink;
import br.com.regrasdinamicas.regras.email.AnexarArquivoEmail;
import br.com.regrasdinamicas.regras.email.EnviarEmail;
import br.com.regrasdinamicas.vo.Arquivo;
import br.com.regrasdinamicas.vo.Email;
import br.com.regrasdinamicas.vo.Pessoa;

public class EnviarEmailComprasPessoaJuridica implements RegraDeNegocio{
	
	Pessoa pessoa;
	String emailOrigem;
	
	public EnviarEmailComprasPessoaJuridica(Pessoa pessoa, String emailOrigem) {
		this.pessoa = pessoa;
		this.emailOrigem = emailOrigem;
	}
	
	public void executar() throws Exception {
		
		Email email = new Email(emailOrigem, pessoa.getEmail());
		EnviarEmail enviarEmail = new EnviarEmail(email);
		
		List<RegraDeNegocio> regrasEnvio = new ArrayList<RegraDeNegocio>();
		regrasEnvio.add(new AdicionarLink(email, "www.linkedin.com.br/reinaldo"));
		
		GerarNotaFiscal gerarNota = new GerarNotaFiscal(pessoa);
		Arquivo nota = (Arquivo) gerarNota.executarRetorno();
		
		regrasEnvio.add(new AnexarArquivoEmail(email, nota));
		enviarEmail.executar(regrasEnvio);
	}

	@Override
	public Collection<?> executarRetornoLista() throws Exception {
		return null;
	}

	@Override
	public Map<?, ?> executarRetornoMapa() throws Exception {
		return null;
	}

	@Override
	public Object executarRetorno() throws Exception {
		return null;
	}

	@Override
	public void executar(Collection<RegraDeNegocio> regras) throws Exception {
	}
}
