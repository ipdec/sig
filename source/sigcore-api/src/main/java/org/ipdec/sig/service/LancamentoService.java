package org.ipdec.sig.service;

import org.ipdec.sig.exception.PessoaInexistenteOuInativaException;
import org.ipdec.sig.model.algaworks.Lancamento;
import org.ipdec.sig.model.algaworks.Pessoa;
import org.ipdec.sig.repository.LancamentoRepository;
import org.ipdec.sig.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LancamentoService {
	
	@Autowired
	private LancamentoRepository lancamentoRepository;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public Lancamento salvar(Lancamento lancamento) {
		Pessoa pessoa = pessoaRepository.getOne(lancamento.getPessoa().getCodigo());
		if(pessoa==null || pessoa.isInativo()) 
			throw new PessoaInexistenteOuInativaException();		
		return lancamentoRepository.save(lancamento);
	}
	
	
	
//	public Pessoa atualizar(Long codigo, Pessoa pessoa) {
//		Pessoa pessoaSalva = buscarPessoaPeloCodigo(codigo);		
//		BeanUtils.copyProperties(pessoa, pessoaSalva, "codigo");
//		return pessoaRepository.save(pessoaSalva);		
//	}
//	
//	public void atualizarPropriedadeAtivo(Long codigo, Boolean ativo) {
//		Pessoa pessoaSalva = buscarPessoaPeloCodigo(codigo);	
//		pessoaSalva.setAtivo(ativo);
//		pessoaRepository.save(pessoaSalva);
//		
//	}
//	
//	private Pessoa buscarPessoaPeloCodigo(Long codigo) {
//		Pessoa pessoaSalva = pessoaRepository.findOne(codigo);
//		if(pessoaSalva ==null)
//			throw new EmptyResultDataAccessException(1);
//		return pessoaSalva;	
//	}
//	

}
