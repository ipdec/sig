package org.ipdec.sig.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Table(name="empresa", schema = "acesso")
@Data
public class Empresa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="empresa_sequence")
	@SequenceGenerator(name = "empresa_sequence", sequenceName = "acesso.empresa_id_empresa_seq", allocationSize = 1)
	@Column(name="id_empresa")
	private Long id;
	
	@NotNull
	@Size(min=3, max=50)
	private String nome;
}

