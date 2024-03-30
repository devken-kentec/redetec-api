package br.com.kentec.redetec.util;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.kentec.redetec.domain.Cep;

@FeignClient(value="cep-consumer",
                 url="https://viacep.com.br/ws")
public interface CepConsumerFeign {
	
	@GetMapping("/{cep}/json")
	Cep getCep(@PathVariable("cep") String cep); 
}
