package org.ipdec.sig.model.algaworks;

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
@Table(name="categoria", schema = "algaworks")
@Data
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="categoria_sequence")
	@SequenceGenerator(name = "categoria_sequence", sequenceName = "algaworks.categoria_codigo_seq", allocationSize = 1)
	private Long codigo;
	
	@NotNull
	@Size(min=3, max=20)
	private String nome;
}

