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

import br.com.kentec.redetec.DTO.BanhoDTO;
import br.com.kentec.redetec.domain.Banho;
import br.com.kentec.redetec.service.BanhoService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rede-tecnologia/api/banho-tosa/v1")
public class BanhoController {
	
	@Autowired
	private BanhoService bs;
	
	@GetMapping("/recuperar/{id}")
	public ResponseEntity<Optional<BanhoDTO>> listarUm(@PathVariable("id") Long id){
		return ResponseEntity.ok(bs.findById(id));
	}
	
	@GetMapping("/listarBanho")
	public ResponseEntity<Iterable<BanhoDTO>> listarTodos(){
		return ResponseEntity.ok(bs.findAll());
	}
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public Banho gravar(@RequestBody BanhoDTO banhoDTO) {
		return bs.save(banhoDTO);
	}
	
	@PutMapping()
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Banho update(@RequestBody BanhoDTO banhoDTO) {
		return bs.update(banhoDTO);
	}
	
	@PatchMapping("/delete/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Banho delete(@RequestBody String status, @PathVariable("id") Long id) {
		return bs.delete(status, id);
	}
}
