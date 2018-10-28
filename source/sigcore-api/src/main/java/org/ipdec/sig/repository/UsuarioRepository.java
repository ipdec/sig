package org.ipdec.sig.repository;

import java.util.Optional;

import org.ipdec.sig.model.algaworks.UsuarioAlga;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioAlga, Long> {
	
	public Optional<UsuarioAlga> findByEmail(String email);

}
