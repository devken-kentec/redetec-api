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

import br.com.kentec.redetec.domain.TipoBanhoTosa;
import br.com.kentec.redetec.service.TipoBanhoTosaService;

@RestController
@RequestMapping("/rede-tecnologia/api/tipoBanhoTosa/v1")
public class TipoBanhoTosaController {
	
	@Autowired
	private TipoBanhoTosaService tbts;
	
	@GetMapping("/recuperar/{id}")
	public ResponseEntity<Optional<TipoBanhoTosa>> listarUm(@PathVariable("id") Long id){
		return ResponseEntity.ok(tbts.findById(id));
	}
	
	@GetMapping("/listarTipoBanhoTosa")
	public ResponseEntity<Iterable<TipoBanhoTosa>> listarTodos(){
		return ResponseEntity.ok(tbts.findAll());
	}
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public TipoBanhoTosa gravar(@RequestBody TipoBanhoTosa tipoBanhoTosa) {
		return tbts.save(tipoBanhoTosa);
	}
	
	@PutMapping()
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public TipoBanhoTosa update(@RequestBody TipoBanhoTosa tipoBanhoTosa) {
		return tbts.update(tipoBanhoTosa);
	}
	
	@PatchMapping("/delete/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public TipoBanhoTosa delete(@RequestBody String status, @PathVariable("id") Long id) {
		return tbts.delete(status, id);
	}
	
}
