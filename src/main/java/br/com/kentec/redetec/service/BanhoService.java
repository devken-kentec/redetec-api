package br.com.kentec.redetec.service;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.kentec.redetec.DTO.BanhoDTO;
import br.com.kentec.redetec.domain.Animal;
import br.com.kentec.redetec.domain.Banho;
import br.com.kentec.redetec.domain.TipoBanhoTosa;
import br.com.kentec.redetec.repository.AnimalRepository;
import br.com.kentec.redetec.repository.BanhoRepository;
import br.com.kentec.redetec.repository.TipoBanhoTosaRepository;

@Service
public class BanhoService {
	
	@Autowired
	private AnimalRepository ar;
	
	@Autowired
	private TipoBanhoTosaRepository tbtr;
	
	@Autowired
	private BanhoRepository br;
	
	public Optional<BanhoDTO> findById(Long id){
		return br.findById(id).map(BanhoDTO::new);
	}
	
	public Iterable<BanhoDTO> findAll() {
		return br.findAll().stream().map(BanhoDTO::new).collect(Collectors.toList());
	}
	
	public Banho save(BanhoDTO banhoDTO) {
		Optional<Animal> animal = ar.findById(banhoDTO.getAnimal());
		Optional<TipoBanhoTosa> tipoBanhoTosa = tbtr.findById(banhoDTO.getTipoBanhoTosa());
		Banho banho = new Banho();
		
		if(animal.isPresent() && tipoBanhoTosa.isPresent()) {
			banho.setAnimal(animal.get());
			banho.setTipoBanhoTosa(tipoBanhoTosa.get());
			banho.setIncio(banhoDTO.getInicio());
			banho.setTermino(banhoDTO.getTermino());
			banho.setStatusBanhoTosa(banhoDTO.getStatusBanhoTosa());
			banho.setObservacao(banhoDTO.getObservacao());
			banho.setStatus(banhoDTO.getStatus());
		}
		return br.save(banho);
	}
	
	public Banho update(BanhoDTO banhoDTO) {
		Optional<Banho> banho = br.findById(banhoDTO.getId());
		Optional<Animal> animal = ar.findById(banhoDTO.getAnimal());
		Optional<TipoBanhoTosa> tipoBanhoTosa = tbtr.findById(banhoDTO.getTipoBanhoTosa());
		
		if(banho.isPresent()) {
			if(animal.isPresent() && tipoBanhoTosa.isPresent()) {
				banho.get().getId();
				banho.get().setAnimal(animal.get());
				banho.get().setTipoBanhoTosa(tipoBanhoTosa.get());
				banho.get().setIncio(banhoDTO.getInicio());
				banho.get().setTermino(banhoDTO.getTermino());
				banho.get().setStatusBanhoTosa(banhoDTO.getStatusBanhoTosa());
				banho.get().setObservacao(banhoDTO.getObservacao());
				banho.get().setStatus(banhoDTO.getStatus());
			}
		}
		return br.save(banho.get());
	}
	
	public Banho delete(String status, Long id) {
		Optional<Banho> banho = br.findById(id);
		if(banho.isPresent()) {
			banho.get().setStatus(status);
		}
		return br.save(banho.get());
	}
}
