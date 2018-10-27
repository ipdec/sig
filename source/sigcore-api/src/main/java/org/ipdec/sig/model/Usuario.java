package org.ipdec.sig.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="usuario", schema = "algaworks")
@EqualsAndHashCode
@Data
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="usuario_sequence")
	@SequenceGenerator(name = "usuario_sequence", sequenceName = "algaworks.usuario_codigo_seq", allocationSize = 1)
	private Long codigo;
	
	@NotNull
	private String nome;
	
	@NotNull
	private String email;
	
	@NotNull
	private String senha;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name="usuario_permissao", 
			joinColumns=@JoinColumn(name="codigo_usuario"),
			inverseJoinColumns=@JoinColumn(name = "codigo_permissao"))
	private List<Permissao> permissoes;	
	
	

}
