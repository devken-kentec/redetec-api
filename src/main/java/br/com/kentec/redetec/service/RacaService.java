package br.com.kentec.redetec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.kentec.redetec.domain.Raca;
import br.com.kentec.redetec.repository.RacaRepository;

@Service
public class RacaService {
	
	@Autowired
	private RacaRepository rr;
	
	public Iterable<Raca> listarRaca() {
		return rr.findAll();
	}
	
	public Raca salvarRaca(Raca raca) {
		return rr.save(raca);
	}
}
