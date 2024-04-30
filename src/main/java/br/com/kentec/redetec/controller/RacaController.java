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

import br.com.kentec.redetec.domain.Raca;
import br.com.kentec.redetec.service.RacaService;


@RestController
@RequestMapping("/rede-tecnologia/api/raca/v1")
public class RacaController {
	
	@Autowired
	private RacaService rs;
	
	@GetMapping("/recuperar/{id}")
	public ResponseEntity<Optional<Raca>> findById(@PathVariable("id") Long id){
		return ResponseEntity.ok(rs.findById(id));
	}
	
	@GetMapping("/listarRaca")
	public ResponseEntity<Iterable<Raca>> listarRaca(){
		return ResponseEntity.ok(rs.listarRaca());
	}
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public Raca gravarEntrega(@RequestBody Raca raca) {
		return rs.salvarRaca(raca);
	}
	
	@PutMapping()
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Raca update(@RequestBody Raca raca) {
		return rs.update(raca);
	}
}
