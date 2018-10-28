package org.ipdec.sig.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.ipdec.sig.event.RecursoCriadoEvent;
import org.ipdec.sig.model.Empresa;
import org.ipdec.sig.model.algaworks.Pessoa;
import org.ipdec.sig.repository.EmpresaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/empresas")
public class EmpresaResource {
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;

	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_CATEGORIA') and #oauth2.hasScope('read')")
	public List<Empresa> listar() {
		return empresaRepository.findAll();
	}
	
	@PostMapping
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_CATEGORIA') and #oauth2.hasScope('write')")
	public ResponseEntity<Empresa> criar(@Valid @RequestBody Empresa empresa, HttpServletResponse response) {
		Empresa empresaSalva = empresaRepository.save(empresa);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, empresaSalva.getId()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(empresaSalva);
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_CATEGORIA') and #oauth2.hasScope('read')")
	public ResponseEntity<Empresa> buscarPeloCodigo(@PathVariable Long id) {
		
		Empresa empresa = empresaRepository.getOne(id);
		
		if(empresa == null)
			return ResponseEntity.notFound().build();
			
		return ResponseEntity.ok(empresa);		
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Empresa> atualizar(@PathVariable Long id, @Valid @RequestBody Pessoa pessoa) {
		Empresa empresaSalva = empresaRepository.getOne(id);
		
		BeanUtils.copyProperties(pessoa, empresaSalva, "id");
		
		empresaRepository.save(empresaSalva);
		
		return ResponseEntity.ok(empresaSalva);
		
		
	}
	
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long id) {
		empresaRepository.deleteById(id);
	}
	
}
