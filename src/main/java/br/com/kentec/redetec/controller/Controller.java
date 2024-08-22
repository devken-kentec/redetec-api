package br.com.kentec.redetec.controller;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.kentec.redetec.configuration.SecurityApi;
import br.com.kentec.redetec.domain.Cep;
import br.com.kentec.redetec.service.SendEmailService;
import br.com.kentec.redetec.util.CepConsumerFeign;
import br.com.kentec.redetec.util.Utilidades;

@RestController
@RequestMapping("/rede-tecnologia/api/teste/v1")
public class Controller {
	
	@Autowired
	private CepConsumerFeign ccp;
	
	@Autowired
	private SendEmailService ses;
	
	@GetMapping()
	public void testeAPI() throws UnsupportedEncodingException, MessagingException {
		System.out.println("读取文件 时出错,请确认文件 存在且配置的用户有权限读取");
        System.out.println("厨房的横梁上挂着一串洋葱。");
        System.out.println("你扯动细绳，木偶的手脚就会动。");
        System.out.println("अक्तूबर, अक्‍टूबर\" \"कौम, क़ौम");
        /*System.out.println("Funciona!");
        
       Cep cep = ccp.getCep("74391550"); 
        System.out.println(cep);
        
        ses.enviarEmalHtml("读取文件 时出错,请确认文件 存在且配置的用户有权限读取", "Teste01", "kennedy_tomazete@outlook.com");
        ses.enviarEmalHtml("Teste", "Teste01", "junnyelly@hotmail.com");
        
        SecurityApi.setSecurityApi();
        
        SecurityApi.verificaValidacaoApi();*/
        
        System.out.println(Utilidades.encodeB64("12345"));
        System.out.println(Utilidades.decodeB64(Utilidades.encodeB64("12345")));
	}
}
