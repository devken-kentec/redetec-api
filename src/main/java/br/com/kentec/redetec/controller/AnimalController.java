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

import br.com.kentec.redetec.DTO.AnimalDTO;
import br.com.kentec.redetec.domain.Animal;
import br.com.kentec.redetec.service.AnimalService;

@RestController
@RequestMapping("/rede-tecnologia/api/animal/v1")
public class AnimalController {
	
	@Autowired
	private AnimalService as;
	
	@GetMapping("/recuperar/{id}")
	public ResponseEntity<Optional<AnimalDTO>> listarUm(@PathVariable("id") Long id){
		return ResponseEntity.ok(as.findById(id));
	}
	
	@GetMapping("/listarAnimal")
	public ResponseEntity<Iterable<AnimalDTO>> listarTodos(){
		return ResponseEntity.ok(as.findAll());
	}
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public Animal gravar(@RequestBody AnimalDTO animalDTO) {
		return as.save(animalDTO);
	}
	
	@PutMapping()
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Animal update(@RequestBody AnimalDTO animalDTO) {
		return as.update(animalDTO);
	}
	
	@PatchMapping("/delete/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Animal delete(@RequestBody String status, @PathVariable("id") Long id) {
		return as.delete(status, id);
	}
	
	@GetMapping("/select")
	public ResponseEntity<List<Animal>> selectAnimalComboBox(){
		return ResponseEntity.ok(as.selectAnimalComboBox());
	}
}
