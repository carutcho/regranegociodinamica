package br.com.regrasdinamicas.exception;

public class ServiceBusinessException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public ServiceBusinessException(String mensagem) {
		super(mensagem);
	}

}
