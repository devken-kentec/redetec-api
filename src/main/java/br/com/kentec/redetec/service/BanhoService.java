package br.com.kentec.redetec.service;

import java.io.UnsupportedEncodingException;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.kentec.redetec.DTO.BanhoDTO;
import br.com.kentec.redetec.domain.Animal;
import br.com.kentec.redetec.domain.Banho;
import br.com.kentec.redetec.domain.TipoBanhoTosa;
import br.com.kentec.redetec.repository.AnimalRepository;
import br.com.kentec.redetec.repository.BanhoRepository;
import br.com.kentec.redetec.repository.TipoBanhoTosaRepository;
import br.com.kentec.redetec.util.Utilidades;

@Service
public class BanhoService {
	
	@Autowired
	private AnimalRepository ar;
	
	@Autowired
	private TipoBanhoTosaRepository tbtr;
	
	@Autowired
	private BanhoRepository br;
	
	@Autowired
	private SendEmailService ses;
	
	public Optional<BanhoDTO> findById(Long id){
		return br.findById(id).map(BanhoDTO::new);
	}
	
	public Iterable<BanhoDTO> findAll() {
		return br.findAll().stream().map(BanhoDTO::new).collect(Collectors.toList());
	}
	
	public Iterable<BanhoDTO> listarBanhoDiaAtual() {
		var dataHoje = Utilidades.dataAtual();
		return br.listarBanhoDiaAtual("%" + dataHoje + "%").stream().map(BanhoDTO::new).collect(Collectors.toList());
	}
	
	public Iterable<BanhoDTO> listarBanhoAnimalStatusPagamento(Long animal, String statusPagamentoBanho) {
			return br.listarBanhoAnimalStatusPagamento(animal, statusPagamentoBanho)
				.stream().map(BanhoDTO::new).collect(Collectors.toList());  
	}
	
	public Iterable<BanhoDTO> listarBanhoStatusPagamento(String statusPagamentoBanho) {
		return br.listarBanhoStatusPagamento(statusPagamentoBanho)
			.stream().map(BanhoDTO::new).collect(Collectors.toList());  
}
	
	public Iterable<BanhoDTO> listarBanhoAnimalData(String data) {
		return br.listarBanhoAnimalData("%"+data+"%").stream().map(BanhoDTO::new).collect(Collectors.toList());
	}
	
	public Iterable<BanhoDTO> listarBanhoAnimalInativo() {
		return br.listarBanhoInativo().stream().map(BanhoDTO::new).collect(Collectors.toList());
	}
	
	public Banho save(BanhoDTO banhoDTO) {
		Optional<Animal> animal = ar.findById(banhoDTO.getAnimal());
		Optional<TipoBanhoTosa> tipoBanhoTosa = tbtr.findById(banhoDTO.getTipoBanhoTosa());
		Banho banho = new Banho();
		
		if(animal.isPresent() && tipoBanhoTosa.isPresent()) {
			banho.setAnimal(animal.get());
			banho.setTipoBanhoTosa(tipoBanhoTosa.get());
			banho.setInicio(banhoDTO.getInicio());
			banho.setTermino(banhoDTO.getTermino());
			banho.setStatusBanhoTosa(banhoDTO.getStatusBanhoTosa());
			banho.setObservacao(banhoDTO.getObservacao());
			banho.setStatus(banhoDTO.getStatus());
			banho.setStatusPagamentoBanho(banhoDTO.getStatusPagamentoBanho());
			banho.setTransporte(banhoDTO.getTransporte());
			banho.setBuscar(banhoDTO.getBuscar());
			banho.setEntregar(banhoDTO.getEntregar());
			banho.setDesconto(banhoDTO.getDesconto());
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
				banho.get().setInicio(banhoDTO.getInicio());
				banho.get().setTermino(banhoDTO.getTermino());
				banho.get().setStatusBanhoTosa(banhoDTO.getStatusBanhoTosa());
				banho.get().setObservacao(banhoDTO.getObservacao());
				banho.get().setStatus(banhoDTO.getStatus());
				banho.get().setStatusPagamentoBanho(banhoDTO.getStatusPagamentoBanho());
				banho.get().setTransporte(banhoDTO.getTransporte());
				banho.get().setBuscar(banhoDTO.getBuscar());
				banho.get().setEntregar(banhoDTO.getEntregar());
				banho.get().setDesconto(banhoDTO.getDesconto());
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
	
	public void atualizaStatusBanho(String status, Long id) throws UnsupportedEncodingException, MessagingException {
		Optional<Banho> banho = br.findById(id);
		if(banho.isPresent()) {
			if(status.equals("enviarEmail")) {
				var email = banho.get().getAnimal().getHumano().getEmail();
				var msg = "O banho Finalizaou " + banho.get().getAnimal().getNome() + " esta limpinho, pode vir buscar!"; 
				var assunto = "KasaPet - Banho";
				 ses.enviarEmalHtml(assunto, msg, email);
			} else {
				banho.get().setStatusBanhoTosa(status);
				br.save(banho.get());
			}
		}
	}
}
