package br.com.regrasdinamicas.interfaces;

import java.util.Collection;
import java.util.Map;

public interface RegraDeNegocio {

	public void executar() throws Exception;
	
	public Collection<?> executarRetornoLista() throws Exception;
	
	public Map<?,?> executarRetornoMapa() throws Exception;
	
	public Object executarRetorno() throws Exception;
	
	public void executar(Collection<RegraDeNegocio> regras) throws Exception;
	
}
