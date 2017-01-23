package br.com.regrasdinamicas.regras.email;

import java.util.Collection;

import br.com.regrasdinamicas.exception.ServiceBusinessException;
import br.com.regrasdinamicas.interfaces.RegraDeNegocio;
import br.com.regrasdinamicas.vo.Arquivo;
import br.com.regrasdinamicas.vo.Email;

public class AnexarArquivoEmail implements RegraDeNegocio {
	
	Arquivo anexo;
	Email email;
	
	public AnexarArquivoEmail(Email email, Arquivo anexo) {
		this.anexo = anexo;
		this.email = email;
	}
	
	@Override
	public void executar() throws ServiceBusinessException {
		System.out.println("\n --- Estou anexando o arquivo [" + anexo.getNome() + "] no caminho [" + anexo.getCaminho() + "] no e-mail para [" + email.getEnderecoDestino() +"]" );
		email.setAnexo(anexo);
	}

	@Override
	public void executar(Collection<RegraDeNegocio> regras) throws ServiceBusinessException {
	}

	@Override
	public Collection<Object> executarRetornoLista() throws ServiceBusinessException {
		return null;
	}

	@Override
	public Object executarRetornoSimples() throws ServiceBusinessException {
		return null;
	}

}
