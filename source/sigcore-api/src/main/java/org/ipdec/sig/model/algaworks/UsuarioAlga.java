package org.ipdec.sig.model.algaworks;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="usuario", schema = "algaworks")
@EqualsAndHashCode
@Data
public class UsuarioAlga {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
