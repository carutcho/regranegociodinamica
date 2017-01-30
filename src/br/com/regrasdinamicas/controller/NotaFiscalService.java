package br.com.regrasdinamicas.controller;

import java.util.List;

import br.com.regrasdinamicas.vo.Pessoa;

public interface NotaFiscalService {
	
	public void enviarEmailCompras(List<Pessoa> pessoasEnviarEmail) throws Exception;
}
