package br.com.regrasdinamicas.regras.email;

import java.util.Collection;
import java.util.Map;

import br.com.regrasdinamicas.exception.ServiceBusinessException;
import br.com.regrasdinamicas.interfaces.RegraDeNegocio;
import br.com.regrasdinamicas.vo.Email;
import br.com.regrasdinamicas.vo.Pessoa;

public class EnviarEmail implements RegraDeNegocio {

	Pessoa pessoa;
	Email email; 
	
	public EnviarEmail(Pessoa pessoa, Email email) {
		this.pessoa = pessoa;
		this.email = email;
	}

	@Override
	public void executar() throws Exception {
		email.setDestino(pessoa.getEmail());
		enviarEmail();
	}

	@Override
	public void executar(Collection<RegraDeNegocio> regras) throws Exception {
		
		email.setDestino(pessoa.getEmail());
		System.out.println("\n --- Enviando um detalhado para [" + email.getDestino() + "]");
		
		for (RegraDeNegocio regraDeNegocio : regras) {
			regraDeNegocio.executar();
		}
		
		enviarEmail();
	}

	private void enviarEmail() throws ServiceBusinessException{
		
		if (email.getDestino() == null || email.getDestino().equals("")){
			throw new ServiceBusinessException("[ERRO] O destinatario precisa de um e-mail cadastrado!");
		}
		System.out.println("\n --- Enviado um e-mail para [" + email.getDestino() + "]");		
	}

	@Override
	public Collection<Object> executarRetornoLista() throws Exception {
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
