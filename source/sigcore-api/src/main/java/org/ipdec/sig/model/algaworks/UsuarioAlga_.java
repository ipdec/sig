package org.ipdec.sig.model.algaworks;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(UsuarioAlga.class)
public abstract class UsuarioAlga_ {

	public static volatile SingularAttribute<UsuarioAlga, String> senha;
	public static volatile ListAttribute<UsuarioAlga, Permissao> permissoes;
	public static volatile SingularAttribute<UsuarioAlga, Long> codigo;
	public static volatile SingularAttribute<UsuarioAlga, String> nome;
	public static volatile SingularAttribute<UsuarioAlga, String> email;

}

