package org.ipdec.sig.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name="lancamento", schema = "algaworks")
@Data
public class Lancamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="lancamento_sequence")
	@SequenceGenerator(name = "lancamento_sequence", sequenceName = "algaworks.lancamento_codigo_seq", allocationSize = 1)
	private Long codigo;
		
	@NotNull
	private String descricao;

	@NotNull
	@Column(name="data_vencimento")
	private LocalDate dataVencimento;
	
	@Column(name="data_pagamento")
	private LocalDate dataPagamento;
	
	@NotNull
	private BigDecimal valor;
	
	private String observacao;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private TipoLancamento tipo;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name= "codigo_categoria")
	private Categoria categoria;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name= "codigo_pessoa")
	private Pessoa pessoa;
}

