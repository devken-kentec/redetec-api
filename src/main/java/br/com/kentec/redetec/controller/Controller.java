package br.com.kentec.redetec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.kentec.redetec.domain.Cep;
import br.com.kentec.redetec.util.CepConsumerFeign;

@RestController
@RequestMapping("/rede-tecnologia/api/teste/v1")
public class Controller {
	
	@Autowired
	private CepConsumerFeign ccp;
	
	@GetMapping()
	public void testeAPI() {
		System.out.println("读取文件 时出错,请确认文件 存在且配置的用户有权限读取");
        System.out.println("厨房的横梁上挂着一串洋葱。");
        System.out.println("你扯动细绳，木偶的手脚就会动。");
        System.out.println("अक्तूबर, अक्‍टूबर\" \"कौम, क़ौम");
        System.out.println("Funciona!");
        
        Cep cep = ccp.getCep("74391550"); 
        System.out.println(cep);
	}
}
