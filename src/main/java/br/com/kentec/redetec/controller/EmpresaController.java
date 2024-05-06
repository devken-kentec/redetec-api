package br.com.kentec.redetec.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.kentec.redetec.domain.Empresa;
import br.com.kentec.redetec.service.EmpresaService;

@RestController
@RequestMapping("/rede-tecnologia/api/empresa/v1")
public class EmpresaController {
	
	@Autowired
	private EmpresaService es;
	
	@GetMapping("/recuperar/{id}")
	public ResponseEntity<Optional<Empresa>> listarUm(@PathVariable("id") Long id){
		return ResponseEntity.ok(es.findById(id));
	}
	
	@GetMapping("/listarEmpresa")
	public ResponseEntity<Iterable<Empresa>> listarTodos(){
		return ResponseEntity.ok(es.findAll());
	}
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public Empresa gravar(@RequestBody Empresa empresa) {
		return es.save(empresa);
	}
	
	@PutMapping()
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Empresa update(@RequestBody Empresa empresa) {
		return es.update(empresa);
	}
	
	@PatchMapping("/delete/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Empresa delete(@RequestBody String status, @PathVariable("id") Long id) {
		return es.delete(status, id);
	}
}
