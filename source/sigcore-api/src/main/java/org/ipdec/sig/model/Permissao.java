package org.ipdec.sig.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="permissao", schema = "algaworks")
@Data
@EqualsAndHashCode	
public class Permissao {

	@Id
	private Long codigo;
	
	@NotNull
	private String descricao;

}
