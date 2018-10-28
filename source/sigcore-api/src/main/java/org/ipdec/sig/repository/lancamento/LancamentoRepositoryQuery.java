package org.ipdec.sig.repository.lancamento;

import org.ipdec.sig.model.algaworks.Lancamento;
import org.ipdec.sig.repository.filter.LancamentoFilter;
import org.ipdec.sig.repository.projection.ResumoLancamento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LancamentoRepositoryQuery {
	
	public Page<Lancamento> filtrar(LancamentoFilter lancamentoFilter, Pageable pageable);
	public Page<ResumoLancamento> resumir(LancamentoFilter lancamentoFilter, Pageable pageable);

}
