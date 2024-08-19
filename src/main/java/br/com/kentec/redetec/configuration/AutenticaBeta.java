package br.com.kentec.redetec.configuration;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.kentec.redetec.DTO.AcessoDTO;
import br.com.kentec.redetec.DTO.LoginDTO;
import br.com.kentec.redetec.domain.Acesso;
import br.com.kentec.redetec.domain.Humano;
import br.com.kentec.redetec.domain.Login;
import br.com.kentec.redetec.domain.Token;
import br.com.kentec.redetec.repository.AcessoRepository;
import br.com.kentec.redetec.repository.HumanoRepository;
import br.com.kentec.redetec.repository.LoginRepository;
import br.com.kentec.redetec.service.SendEmailService;
import br.com.kentec.redetec.util.Utilidades;

@RestController
@RequestMapping("/rede-tecnologia/api/AutenticaoBeta/v1")
public class AutenticaBeta {
		
	@Autowired 
	private Token tk;
	
	@Autowired
	private HumanoRepository hr; 
	
	@Autowired
	private LoginRepository lr;
	
	@Autowired
	private AcessoRepository ar;
	
	@Autowired
	private SendEmailService ses;
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public AcessoDTO autenticaoRapida(@RequestHeader("Token") String token, @RequestBody LoginDTO loginDTO) {
		
		AcessoDTO acessoDTO = new AcessoDTO();
		
		if(tk.getToken().equals(token)) {
			SecurityApi.setSecurityApi();
			Optional<Humano> humano = hr.findByEmail(loginDTO.getEmail());
			if(humano.isPresent()) {
				Optional<Login> login = lr.findByHumano(humano.get());
				if(login.isPresent()) {
					if(login.get().getSenha().equals(Utilidades.encodeB64(loginDTO.getSenha()))) {
						Iterable<Acesso> acesso = ar.findAllLogin(login.get());
						acessoDTO.setId(humano.get().getId());
						acessoDTO.setAutenticacao(true);
						acessoDTO.setNome(humano.get().getNome());
						
						List<String> descricao = new ArrayList<>();
						acesso.forEach(elemento ->{
							descricao.add(elemento.getDescricao());
						});
						acessoDTO.setDescricao(descricao);
					}					
				}
			}
			SecurityApi.verificaValidacaoApi();
		}
		return acessoDTO;
	}
	
	@PostMapping("/recuperar")
	@ResponseStatus(HttpStatus.CREATED)
	public void recupararSenha(@RequestHeader("Token") String token, @RequestBody LoginDTO loginDTO) throws UnsupportedEncodingException, MessagingException {
		if(tk.getToken().equals(token)) {
			Optional<Humano> humano = hr.findByEmail(loginDTO.getEmail());
			if(humano.isPresent()) {
				Optional<Login> login = lr.findByHumano(humano.get());
				if(login.isPresent()) {
					var novaSenha = Utilidades.gerarSenhaAleatoria();
					login.get().setSenha(Utilidades.encodeB64(novaSenha));	
					lr.save(login.get());
					ses.enviarEmalHtml("Recuperação de Senha", novaSenha, loginDTO.getEmail());
				}
			}
		}
	}
	
	@PostMapping("/alterar")
	@ResponseStatus(HttpStatus.CREATED)
	public void alterarSenha(@RequestHeader("Token") String token, @RequestBody LoginDTO loginDTO) {
		if(tk.getToken().equals(token)) {
			Optional<Humano> humano = hr.findByEmail(loginDTO.getEmail());
			if(humano.isPresent()) {
				Optional<Login> login = lr.findByHumano(humano.get());
				if(login.isPresent()) {
					if(login.get().getSenha().equals(Utilidades.encodeB64(loginDTO.getSenha()))) {
						login.get().setSenha(Utilidades.encodeB64(loginDTO.getNovaSenha()));	
						lr.save(login.get());
					}					
				}
			}
		}
	}
}
