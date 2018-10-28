package org.ipdec.sig.model.algaworks;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name="pessoa", schema = "algaworks")
@Data
public class Pessoa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="pessoa_sequence")
	@SequenceGenerator(name = "pessoa_sequence", sequenceName = "algaworks.pessoa_codigo_seq", allocationSize = 1)
	private Long codigo;
		
	@NotNull
	@Size(min=3, max=50)
	private String nome;
	
	@NotNull
	private Boolean ativo;
	
	@JsonIgnore
	@Transient
	public boolean isInativo() {
		return !this.ativo;
	}
	
	@Embedded
	private Endereco endereco;
}

