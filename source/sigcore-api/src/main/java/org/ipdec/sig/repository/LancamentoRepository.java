package org.ipdec.sig.repository;

import org.ipdec.sig.model.Lancamento;
import org.ipdec.sig.repository.lancamento.LancamentoRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long>, LancamentoRepositoryQuery {

}
