package br.com.regrasdinamicas.interfaces;

import java.util.Collection;

public interface RegraDeNegocio {

	public void executar() throws Exception;
	
	public Collection<Object> executarRetornoLista() throws Exception;
	
	public Object executarRetornoSimples() throws Exception;
	
	public void executar(Collection<RegraDeNegocio> regras) throws Exception;
}
