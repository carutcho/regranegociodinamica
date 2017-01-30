package br.com.regrasdinamicas.regras.notafiscal;

import java.util.Collection;
import java.util.Map;

import br.com.regrasdinamicas.exception.ServiceBusinessException;
import br.com.regrasdinamicas.interfaces.RegraDeNegocio;
import br.com.regrasdinamicas.regras.email.EnviarEmail;
import br.com.regrasdinamicas.vo.Email;
import br.com.regrasdinamicas.vo.Pessoa;

public class EnviarEmailComprasPessoaFisica implements RegraDeNegocio{

	Pessoa pessoa;
	String origem;
	
	public EnviarEmailComprasPessoaFisica(Pessoa pessoa, String origem) {
		this.pessoa = pessoa;
		this.origem = origem;
	}

	public void executar() throws Exception {
		
		validarOrigem();
		validarDestino();
		
		Email email = new Email(origem, pessoa.getEmail());
		EnviarEmail enviarEmail = new EnviarEmail(email);
		enviarEmail.executar();
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

	private void validarDestino() throws ServiceBusinessException {
		if(origem==null || origem.equals("")){
			throw new ServiceBusinessException("Email de origem deve ser preenchido");
		}
	}

	private void validarOrigem() throws ServiceBusinessException {
		if(pessoa != null && (pessoa.getEmail()==null || pessoa.getEmail().equals(""))){
			throw new ServiceBusinessException("Email de destino deve ser preenchido");
		}
	}

}
