package br.com.kentec.redetec.service;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.kentec.redetec.DTO.ConfigAcessoDTO;
import br.com.kentec.redetec.domain.Acesso;
import br.com.kentec.redetec.domain.Humano;
import br.com.kentec.redetec.domain.Login;
import br.com.kentec.redetec.repository.AcessoRepository;
import br.com.kentec.redetec.repository.HumanoRepository;
import br.com.kentec.redetec.repository.LoginRepository;
import br.com.kentec.redetec.util.Utilidades;

@Service
public class AcessoService {
	
	@Autowired
	private AcessoRepository ar;
	
	@Autowired
	private HumanoRepository hr;
	
	@Autowired
	private LoginRepository lr;
	
	public Optional<ConfigAcessoDTO> findById(Long id){
		return ar.findById(id).map(ConfigAcessoDTO::new);
	}
	
	public Iterable<ConfigAcessoDTO> findAll(){
		return ar.findAll().stream().map(ConfigAcessoDTO::new).collect(Collectors.toList());
	}
	
	public Acesso save(ConfigAcessoDTO configAcessoDTO) {
		Optional<Humano> humano = hr.findById(configAcessoDTO.getIdNome());
		Login loginNovo = null;
		Acesso acessoNovo = null;
		if(humano.isPresent()) {
			Login login = new Login();
			login.setLogin(configAcessoDTO.getLogin());
			login.setPin(configAcessoDTO.getPin());
			login.setSenha(Utilidades.encodeB64(configAcessoDTO.getSenha()));
			login.setStatus(configAcessoDTO.getStatusLogin());
			login.setHumano(humano.get());
			loginNovo = lr.save(login);
			
			Acesso acesso = new Acesso();
			acesso.setLogin(loginNovo);
			acesso.setDescricao(configAcessoDTO.getDescricao());
			acesso.setStatus(configAcessoDTO.getStatusAcesso());
			acessoNovo = ar.save(acesso);
		}
		return acessoNovo;
	}
	
	public Acesso update(ConfigAcessoDTO configAcessoDTO) {
		Login loginAtualizado = null;
		Acesso acessoAtualizado = null;
		Optional<Humano> humano = hr.findById(configAcessoDTO.getIdNome());
		Optional<Login> login = lr.findByHumano(humano.get());
		
		if(login.isPresent()) {
			login.get().setLogin(configAcessoDTO.getLogin());
			login.get().setPin(configAcessoDTO.getPin());
			login.get().setSenha(Utilidades.encodeB64(configAcessoDTO.getSenha()));
			login.get().setStatus(configAcessoDTO.getStatusLogin());
			loginAtualizado = lr.save(login.get());
		}
		
		Optional<Acesso> acesso = ar.findByLogin(loginAtualizado);
		
		if(acesso.isPresent()) {
			acesso.get().setDescricao(configAcessoDTO.getDescricao());
			acesso.get().setStatus(configAcessoDTO.getStatusAcesso());
			acessoAtualizado = ar.save(acesso.get());
		}
		
		return acessoAtualizado;
	}
}
