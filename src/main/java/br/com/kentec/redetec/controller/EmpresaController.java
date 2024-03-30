package br.com.kentec.redetec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.kentec.redetec.service.EmpresaService;

@RestController
@RequestMapping("/rede-tecnologia/api/empresa/v1")
public class EmpresaController {
	
	@Autowired
	private EmpresaService es;
}
