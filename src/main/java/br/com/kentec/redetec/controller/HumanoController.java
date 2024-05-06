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

import br.com.kentec.redetec.DTO.HumanoDTO;
import br.com.kentec.redetec.domain.Humano;
import br.com.kentec.redetec.service.HumanoService;

@RestController
@RequestMapping("/rede-tecnologia/api/humano/v1")
public class HumanoController {
	
	@Autowired
	private HumanoService hs;
	
	@GetMapping("/recuperar/{id}")
	public ResponseEntity<Optional<HumanoDTO>> listarUm(@PathVariable("id") Long id){
		return ResponseEntity.ok(hs.findById(id));
	}
	
	@GetMapping("/listarHumano")
	public ResponseEntity<Iterable<HumanoDTO>> listarTodos(){
		return ResponseEntity.ok(hs.findAll());
	}
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public Humano gravar(@RequestBody HumanoDTO humanoDTO) {
		return hs.save(humanoDTO);
	}
	
	@PutMapping()
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Humano update(@RequestBody HumanoDTO humanoDTO) {
		return hs.update(humanoDTO);
	}
	
	@PatchMapping("/delete/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Humano delete(@RequestBody String status, @PathVariable("id") Long id) {
		return hs.delete(status, id);
	}
}