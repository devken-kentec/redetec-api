package br.com.kentec.redetec.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.kentec.redetec.DTO.AnimalDTO;
import br.com.kentec.redetec.domain.Animal;
import br.com.kentec.redetec.domain.Empresa;
import br.com.kentec.redetec.domain.Humano;
import br.com.kentec.redetec.domain.Raca;
import br.com.kentec.redetec.repository.AnimalRepository;
import br.com.kentec.redetec.repository.EmpresaRepository;
import br.com.kentec.redetec.repository.HumanoRepository;
import br.com.kentec.redetec.repository.RacaRepository;

@Service
public class AnimalService {
	
	@Autowired
	private EmpresaRepository er;
	
	@Autowired
	private HumanoRepository hr;
	
	@Autowired
	private RacaRepository rr;
	
	@Autowired
	private AnimalRepository ar;
	
	public long totalLista() {
		return ar.count();
	}
	
	public Optional<AnimalDTO> findById(Long id){
		return ar.findById(id).map(AnimalDTO::new);
	}
	
	public Iterable<AnimalDTO> findAll() {
		return ar.findAll().stream().map(AnimalDTO::new).collect(Collectors.toList());
	}
	
	public Iterable<AnimalDTO> searchName(Integer page, Integer size, String nome){
		PageRequest pageRequest = PageRequest.of(page, size);
		return ar.searchName("%"+nome+"%", pageRequest).stream().map(AnimalDTO::new).collect(Collectors.toList());
	}
	
	public List<AnimalDTO> listarPaginacaoAnimais(Integer page, Integer size){
		PageRequest pageRequest = PageRequest.of(page, size);
		return ar.findAll(pageRequest).stream().map(AnimalDTO::new).collect(Collectors.toList()) ;
	}
	
	public Animal save(AnimalDTO animalDTO) {
		
		Optional<Empresa> empresa = er.findById(animalDTO.getEmpresa());
		Optional<Humano> humano = hr.findById(animalDTO.getHumano());
		Optional<Raca> raca = rr.findById(animalDTO.getRaca());
		Animal animal = new Animal();
		
		if(empresa.isPresent() && humano.isPresent()) {
			animal.setNome(animalDTO.getNome());
			animal.setDataNascimento(animalDTO.getDataNascimento());
			animal.setCor(animalDTO.getCor());
			animal.setPorte(animalDTO.getPorte());
			animal.setPeso(animalDTO.getPeso());
			animal.setEspecie(animalDTO.getEspecie());
			animal.setSexo(animalDTO.getSexo());
			animal.setObservacao(animalDTO.getObservacao());
			animal.setStatus(animalDTO.getStatus());
			animal.setRaca(raca.get());
			animal.setHumano(humano.get());
			animal.setEmpresa(empresa.get());
		}
		return ar.save(animal);
	}
	
	public Animal update(AnimalDTO animalDTO) {
		Optional<Animal> animal = ar.findById(animalDTO.getId()); 
		
		if(animal.isPresent()) {
			Optional<Empresa> empresa = er.findById(animalDTO.getEmpresa());
			Optional<Humano> humano = hr.findById(animalDTO.getHumano());
			Optional<Raca> raca = rr.findById(animalDTO.getRaca());
			
			if(empresa.isPresent() && humano.isPresent()) {
				animal.get().setId(animalDTO.getId());
				animal.get().setNome(animalDTO.getNome());
				animal.get().setDataNascimento(animalDTO.getDataNascimento());
				animal.get().setCor(animalDTO.getCor());
				animal.get().setPorte(animalDTO.getPorte());
				animal.get().setPeso(animalDTO.getPeso());
				animal.get().setEspecie(animalDTO.getEspecie());
				animal.get().setSexo(animalDTO.getSexo());
				animal.get().setObservacao(animalDTO.getObservacao());
				animal.get().setStatus(animalDTO.getStatus());
				animal.get().setRaca(raca.get());
				animal.get().setHumano(humano.get());
				animal.get().setEmpresa(empresa.get());
			}
		}
		
		return ar.save(animal.get());
	}
	
	public Animal delete(String status, Long id) {
		System.out.println(status + " - " + id);
		Optional<Animal> animal = ar.findById(id);
		if(animal.isPresent()) {
			animal.get().setStatus(status);
		}
		return ar.save(animal.get());
	}
	
	public List<Animal> selectAnimalComboBox() {
		return ar.selectAnimalComboBox();
	}
}
