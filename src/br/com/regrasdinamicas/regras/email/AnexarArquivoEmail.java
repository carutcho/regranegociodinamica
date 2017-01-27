package br.com.regrasdinamicas.regras.email;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import br.com.regrasdinamicas.exception.ServiceBusinessException;
import br.com.regrasdinamicas.interfaces.RegraDeNegocio;
import br.com.regrasdinamicas.vo.Arquivo;
import br.com.regrasdinamicas.vo.Email;

public class AnexarArquivoEmail implements RegraDeNegocio {
	
	List<Arquivo> anexos;
	Email email;
	
	public AnexarArquivoEmail(Email email, List<Arquivo> anexo) {
		this.anexos = anexo;
		this.email = email;
	}
	
	public AnexarArquivoEmail(Email email, Arquivo anexo) {
		
		List<Arquivo> arquivos = new ArrayList<Arquivo>();
		arquivos.add(anexo);
		
		this.email = email;
		this.anexos = arquivos;
		
	}
	
	@Override
	public void executar() throws ServiceBusinessException {
		System.out.println("\n --- Estou anexando o arquivo [" + anexos.get(0).getNome() + "] no caminho [" + anexos.get(0).getCaminho() + "] no e-mail para [" + email.getDestino() +"]" );
		email.setAnexo(anexos);
	}

	@Override
	public void executar(Collection<RegraDeNegocio> regras) throws ServiceBusinessException {
	}

	@Override
	public Collection<Object> executarRetornoLista() throws ServiceBusinessException {
		return null;
	}

	@Override
	public Map<?, ?> executarRetornoMapa() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object executarRetorno() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
