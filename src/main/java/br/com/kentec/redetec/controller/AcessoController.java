package br.com.kentec.redetec.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.kentec.redetec.DTO.ConfigAcessoDTO;
import br.com.kentec.redetec.domain.Acesso;

import br.com.kentec.redetec.service.AcessoService;

@RestController
@RequestMapping("/rede-tecnologia/api/config-acesso/v1")
public class AcessoController {
	
	@Autowired
	private AcessoService as;
	
	@GetMapping("/recuperar/{id}")
	public ResponseEntity<Optional<ConfigAcessoDTO>> listarUm(@PathVariable("id") Long id){
		return ResponseEntity.ok(as.findById(id));
	}
	
	@GetMapping("/listarAcessos")
	public ResponseEntity<Iterable<ConfigAcessoDTO>> listarTodos(){
		return ResponseEntity.ok(as.findAll());
	}
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public Acesso gravar(@RequestBody ConfigAcessoDTO configAcessoDTO) {
		return as.save(configAcessoDTO);
	}
	
	@PutMapping()
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Acesso update(@RequestBody ConfigAcessoDTO configAcessoDTO) {
		return as.update(configAcessoDTO);
	}
}
