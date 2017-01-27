package br.com.regrasdinamicas.regras.email;

import java.util.Collection;
import java.util.Map;

import br.com.regrasdinamicas.exception.ServiceBusinessException;
import br.com.regrasdinamicas.interfaces.RegraDeNegocio;
import br.com.regrasdinamicas.vo.Email;

public class AdicionarLink implements RegraDeNegocio {

	private Email email;
	private String link;

	public AdicionarLink(Email email, String link) {
		this.email = email;
		this.link = link;
	}
	
	@Override
	public void executar() throws ServiceBusinessException {
		System.out.println("\n --- Adicionei o link [" + link + "] no email para [" + email.getDestino() + "]");
		email.setLink(link);
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
		return null;
	}

	@Override
	public Object executarRetorno() throws Exception {
		return null;
	}

}
