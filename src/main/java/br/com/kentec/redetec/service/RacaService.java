package br.com.kentec.redetec.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.kentec.redetec.domain.Raca;
import br.com.kentec.redetec.repository.RacaRepository;

@Service
public class RacaService {
	
	@Autowired
	private RacaRepository rr;
	
	public Optional<Raca> findById(Long id){
		return rr.findById(id);
	}
	
	public Iterable<Raca> findAll() {
		return rr.findAll();
	}
	
	public Raca save(Raca raca) {
		return rr.save(raca);
	}
	
	public Raca update(Raca raca) {
		Optional<Raca> _raca = rr.findById(raca.getId());
		if(_raca.isPresent()) {
			_raca.get().setId(raca.getId());
			_raca.get().setDescricao(raca.getDescricao());
			_raca.get().setStatus(raca.getStatus());
		}
		return rr.save(_raca.get());
	}
	
	public Raca delete(String status, Long id) {
		System.out.println(status + " - " + id);
		Optional<Raca> raca = rr.findById(id);
		if(raca.isPresent()) {
			raca.get().setStatus(status);
		}
		return rr.save(raca.get());
	}
	
	public List<Raca> selectRacaComboBox() {
		return rr.selectRacaComboBox();
	}
}
