package br.com.regrasdinamicas.regras.notafiscal;

import java.util.Collection;
import java.util.Map;

import br.com.regrasdinamicas.enums.TipoArquivoEnum;
import br.com.regrasdinamicas.exception.ServiceBusinessException;
import br.com.regrasdinamicas.interfaces.RegraDeNegocio;
import br.com.regrasdinamicas.vo.NotaFiscal;
import br.com.regrasdinamicas.vo.Pessoa;

public class GerarNotaFiscal implements RegraDeNegocio{

	Pessoa pessoa;
	
	public GerarNotaFiscal(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	@Override
	public void executar() throws ServiceBusinessException {
	}

	@Override
	public void executar(Collection<RegraDeNegocio> regras) throws ServiceBusinessException {
		
	}

	@Override
	public Collection<Object> executarRetornoLista() throws ServiceBusinessException {
		return null;
	}

	@Override
	public Object executarRetorno() throws ServiceBusinessException {
		
		NotaFiscal nota = new NotaFiscal(pessoa);		
		nota.setCaminho("c:/notas");
		nota.setNome("nota_compra_produto_"+pessoa.getNome());
		nota.setTipo(TipoArquivoEnum.PDF);

		System.out.println("\n --- Nota fiscal criada para [" + pessoa.getNome() + "] com documento ["+ pessoa.getDocumento()+ "]");
		return nota;
	}

	@Override
	public Map<?, ?> executarRetornoMapa() throws Exception {
		return null;
	}

}
