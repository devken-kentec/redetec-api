package br.com.kentec.redetec.controller;

import java.util.List;
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

import br.com.kentec.redetec.domain.Raca;
import br.com.kentec.redetec.service.RacaService;


@RestController
@RequestMapping("/rede-tecnologia/api/raca/v1")
public class RacaController {
	
	@Autowired
	private RacaService rs;
	
	@GetMapping("/recuperar/{id}")
	public ResponseEntity<Optional<Raca>> listarUm(@PathVariable("id") Long id){
		return ResponseEntity.ok(rs.findById(id));
	}
	
	@GetMapping("/listarRaca")
	public ResponseEntity<Iterable<Raca>> listarTodos(){
		return ResponseEntity.ok(rs.findAll());
	}
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public Raca gravar(@RequestBody Raca raca) {
		return rs.save(raca);
	}
	
	@PutMapping()
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Raca update(@RequestBody Raca raca) {
		return rs.update(raca);
	}
	
	@PatchMapping("/delete/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Raca delete(@RequestBody String status, @PathVariable("id") Long id) {
		return rs.delete(status, id);
	}
	
	@GetMapping("/select")
	public ResponseEntity<List<Raca>> selectRacaComboBox(){
		return ResponseEntity.ok(rs.selectRacaComboBox());
	}
	
}
