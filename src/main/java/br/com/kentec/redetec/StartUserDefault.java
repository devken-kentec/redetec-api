package br.com.kentec.redetec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.Transactional;

import br.com.kentec.redetec.domain.Acesso;
import br.com.kentec.redetec.domain.Empresa;
import br.com.kentec.redetec.domain.Humano;
import br.com.kentec.redetec.domain.Login;
import br.com.kentec.redetec.repository.AcessoRepository;
import br.com.kentec.redetec.repository.EmpresaRepository;
import br.com.kentec.redetec.repository.HumanoRepository;
import br.com.kentec.redetec.repository.LoginRepository;
import br.com.kentec.redetec.util.Utilidades;

@Configuration
@Profile("prod")
public class StartUserDefault {
	
	@Autowired
	private EmpresaRepository er;
	
	@Autowired
	private HumanoRepository hr;
	
	@Autowired
	private LoginRepository lr;
	
	@Autowired
	private AcessoRepository ar;
	
	@Bean
	@Transactional
	CommandLineRunner executar() {
		return args -> {
			long humano = hr.count();
			Empresa novaEmpresa;
			Humano novoHumano;
			Login novoLogin;
			
			if(humano == 0) {
				Empresa empresa = new Empresa();
				empresa.setNomeFantasia("KasaPet");
				novaEmpresa = er.save(empresa);
				
				Humano hum = new Humano();
				hum.setNome("Kennedy");
				hum.setSobrenome("Tomazete");
				hum.setStatus("Ativo");
				hum.setEmail("contato@kentec.com.br");
				hum.setEmpresa(novaEmpresa);
				novoHumano = hr.save(hum);
				
				Login login = new Login();
				login.setHumano(novoHumano);
				login.setSenha(Utilidades.encodeB64("123"));
				login.setStatus("Ativo");
				novoLogin = lr.save(login);
				
				Acesso acesso = new Acesso();
				acesso.setLogin(novoLogin);
				acesso.setDescricao("DEV");
				acesso.setStatus("Ativo");
				ar.save(acesso);
			}
		};
	}
}
