package br.com.kentec.redetec.controller;

import java.io.UnsupportedEncodingException;
import java.util.Optional;

import javax.mail.MessagingException;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.kentec.redetec.DTO.BanhoDTO;
import br.com.kentec.redetec.domain.Banho;
import br.com.kentec.redetec.service.BanhoService;

@RestController
@RequestMapping("/rede-tecnologia/api/banho-tosa/v1")
public class BanhoController {
	
	
	@Autowired
	private BanhoService bs;
	
	@GetMapping("/totalLista")
	public ResponseEntity<Long> totalLista(){
		return ResponseEntity.ok(bs.totalLista());
	}
	
	@GetMapping("/recuperar/{id}")
	public ResponseEntity<Optional<BanhoDTO>> listarUm(@PathVariable("id") Long id){
		return ResponseEntity.ok(bs.findById(id));
	}
	
	@GetMapping("/listarBanho")
	public ResponseEntity<Iterable<BanhoDTO>> listarTodos(){
		return ResponseEntity.ok(bs.listarBanhoDiaAtual());
	}
	
	@GetMapping("/listarValorBanhoDia")
	public ResponseEntity<Integer> listarValorBanhoDia(){
		return ResponseEntity.ok(bs.listarValorBanhoDiaAtual());
	}
	
	@GetMapping("/listarBanhoAnimalStatusPagamento")
	public ResponseEntity<Iterable<BanhoDTO>> listarBanhoAnimalStatusPagamento(
			@RequestParam(value="animal", required = false, defaultValue="null") Long animal,
			@RequestParam(value="statusPagamentoBanho", required = false, defaultValue = "null")String statusPagamentoBanho){
		return ResponseEntity.ok(bs.listarBanhoAnimalStatusPagamento(animal, statusPagamentoBanho));
	}
	
	@GetMapping("/listarBanhoStatusPagamento")
	public ResponseEntity<Iterable<BanhoDTO>> listarBanhoStatusPagamento(
			@RequestParam(value="statusPagamentoBanho", required = false, defaultValue = "null")String statusPagamentoBanho){
		return ResponseEntity.ok(bs.listarBanhoStatusPagamento(statusPagamentoBanho));
	}
	
	@GetMapping("/listarBanhoData")
	public ResponseEntity<Iterable<BanhoDTO>> listarBanhoData(
			@RequestParam(value="data", required = false, defaultValue="null") String data){
		return ResponseEntity.ok(bs.listarBanhoAnimalData(data));
	}
	
	@GetMapping("/listarBanhoInativo")
	public ResponseEntity<Iterable<BanhoDTO>> listarBanhoInativo(){
		return ResponseEntity.ok(bs.listarBanhoAnimalInativo());
	}
	
	@GetMapping("/listarBanhoAnimalStatusPagamentoPage")
	public ResponseEntity<Iterable<BanhoDTO>> listarBanhoAnimalStatusPagamentoPage(
			@RequestParam(value="page", defaultValue = "0") Integer page, 
			@RequestParam(value="size", defaultValue = "10") Integer size,
			@RequestParam(value="animal", required = false, defaultValue="null") Long animal,
			@RequestParam(value="statusPagamentoBanho", required = false, defaultValue = "null")String statusPagamentoBanho){
		return ResponseEntity.ok(bs.listarBanhoAnimalStatusPagamentoPage(page, size, animal, statusPagamentoBanho));
	}
	
	@GetMapping("/listarBanhoStatusPagamentoPage")
	public ResponseEntity<Iterable<BanhoDTO>> listarBanhoStatusPagamentoPage(
			@RequestParam(value="page", defaultValue = "0") Integer page, 
			@RequestParam(value="size", defaultValue = "10") Integer size,
			@RequestParam(value="statusPagamentoBanho", required = false, defaultValue = "null")String statusPagamentoBanho){
		return ResponseEntity.ok(bs.listarBanhoStatusPagamentoPage(page, size,statusPagamentoBanho));
	}
	
	@GetMapping("/listarBanhoDataPage")
	public ResponseEntity<Iterable<BanhoDTO>> listarBanhoDataPage(
			@RequestParam(value="page", defaultValue = "0") Integer page, 
			@RequestParam(value="size", defaultValue = "10") Integer size,
			@RequestParam(value="data", required = false, defaultValue="null") String data){
		return ResponseEntity.ok(bs.listarBanhoAnimalDataPage(page, size, data));
	}
	
	@GetMapping("/listarBanhoInativoPage")
	public ResponseEntity<Iterable<BanhoDTO>> listarBanhoInativo(
			@RequestParam(value="page", defaultValue = "0") Integer page, 
			@RequestParam(value="size", defaultValue = "10") Integer size){
		return ResponseEntity.ok(bs.listarBanhoAnimalInativoPage(page, size));
	}
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public Banho gravar(@RequestBody BanhoDTO banhoDTO) {
		return bs.save(banhoDTO);
	}
	
	@PutMapping()
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Banho update(@RequestBody BanhoDTO banhoDTO) {
		return bs.update(banhoDTO);
	}
	
	@PatchMapping("/delete/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Banho delete(@RequestBody String status, @PathVariable("id") Long id) {
		return bs.delete(status, id);
	}
	
	@PatchMapping("/statusBanho/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualizaStatusBanho(@RequestBody String status, @PathVariable("id") Long id) throws UnsupportedEncodingException, MessagingException {
		bs.atualizaStatusBanho(status, id);
	}
}
