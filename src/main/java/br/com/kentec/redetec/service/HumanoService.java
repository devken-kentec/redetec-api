package br.com.kentec.redetec.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.kentec.redetec.DTO.HumanoDTO;
import br.com.kentec.redetec.domain.Empresa;
import br.com.kentec.redetec.domain.Humano;
import br.com.kentec.redetec.repository.EmpresaRepository;
import br.com.kentec.redetec.repository.HumanoRepository;

@Service
public class HumanoService {
	
	@Autowired
	private EmpresaRepository er;
	
	@Autowired
	private HumanoRepository hr;
	
	public long totalLista() {
		return hr.count();
	}
	
	public Optional<HumanoDTO> findById(Long id){
		return hr.findById(id).map(HumanoDTO::new);
	}
	
	public Iterable<HumanoDTO> findAll() {
		return hr.findAll().stream().map(HumanoDTO::new).collect(Collectors.toList());
	}
	
	public List<HumanoDTO> listarPaginacaoHumanos(Integer page, Integer size){
		PageRequest pageRequest = PageRequest.of(page, size);
		return hr.findAll(pageRequest).stream().map(HumanoDTO::new).collect(Collectors.toList()) ;
	}
	
	public Humano save(HumanoDTO humanoDTO) {
		
		Optional<Empresa> empresa = er.findById(humanoDTO.getEmpresa());
		Humano humano = new Humano();
		
		if(empresa.isPresent()) {
			humano.setNome(humanoDTO.getNome());
			humano.setSobrenome(humanoDTO.getSobrenome());
			humano.setDataNascimento(humanoDTO.getDataNascimento());
			humano.setCep(humanoDTO.getCep());
			humano.setEndereco(humanoDTO.getEndereco());
			humano.setComplemento(humanoDTO.getComplemento());
			humano.setFone(humanoDTO.getFone());
			humano.setWhatsapp(humanoDTO.getWhatsapp());
			humano.setEmail(humanoDTO.getEmail());
			humano.setStatus(humanoDTO.getStatus());
			humano.setEmpresa(empresa.get());
		}
		return hr.save(humano);
	}
	
	public Humano update(HumanoDTO humanoDTO) {
		
		Optional<Humano> humano = hr.findById(humanoDTO.getId());
		
		if(humano.isPresent()) {
			Optional<Empresa> empresa = er.findById(humanoDTO.getEmpresa());
			humano.get().setId(humanoDTO.getId());
			humano.get().setNome(humanoDTO.getNome());
			humano.get().setSobrenome(humanoDTO.getSobrenome());
			humano.get().setDataNascimento(humanoDTO.getDataNascimento());
			humano.get().setCep(humanoDTO.getCep());
			humano.get().setEndereco(humanoDTO.getEndereco());
			humano.get().setComplemento(humanoDTO.getComplemento());
			humano.get().setFone(humanoDTO.getFone());
			humano.get().setWhatsapp(humanoDTO.getWhatsapp());
			humano.get().setEmail(humanoDTO.getEmail());
			humano.get().setStatus(humanoDTO.getStatus());
			humano.get().setEmpresa(empresa.get());
		}
		return hr.save(humano.get());
	}
	
	public Humano delete(String status, Long id) {
		System.out.println(status + " - " + id);
		Optional<Humano> humano = hr.findById(id);
		if(humano.isPresent()) {
			humano.get().setStatus(status);
		}
		return hr.save(humano.get());
	}
	
	public List<Humano> selectHumanoComboBox() {
		return hr.selectHumanoComboBox();
	}
}
