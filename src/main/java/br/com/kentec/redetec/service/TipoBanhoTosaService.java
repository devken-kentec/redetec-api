package br.com.kentec.redetec.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.kentec.redetec.domain.TipoBanhoTosa;
import br.com.kentec.redetec.repository.TipoBanhoTosaRepository;

@Service
public class TipoBanhoTosaService {
	
	@Autowired
	private TipoBanhoTosaRepository tbtr;
	
	public Optional<TipoBanhoTosa> findById(Long id){
		return tbtr.findById(id);
	}

	public Iterable<TipoBanhoTosa> findAll() {
		return tbtr.findAll();
	}
	
	public TipoBanhoTosa save(TipoBanhoTosa tipoBanhoTosa) {
		return tbtr.save(tipoBanhoTosa);
	}
	
	public TipoBanhoTosa update(TipoBanhoTosa tipoBanhoTosa) {
		Optional<TipoBanhoTosa> _tipoBanhoTosa = tbtr.findById(tipoBanhoTosa.getId());
		if(_tipoBanhoTosa.isPresent()) {
			_tipoBanhoTosa.get().setId(tipoBanhoTosa.getId());
			_tipoBanhoTosa.get().setDescricao(tipoBanhoTosa.getDescricao());
			_tipoBanhoTosa.get().setValor(tipoBanhoTosa.getValor());
			_tipoBanhoTosa.get().setStatus(tipoBanhoTosa.getStatus());
		}
		return tbtr.save(_tipoBanhoTosa.get());
	}
	
	public TipoBanhoTosa delete(String status, Long id) {
		System.out.println(status + " - " + id);
		Optional<TipoBanhoTosa> tipoBanhoTosa = tbtr.findById(id);
		if(tipoBanhoTosa.isPresent()) {
			tipoBanhoTosa.get().setStatus(status);
		}
		return tbtr.save(tipoBanhoTosa.get());
	}

}
