package br.com.kentec.redetec.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Token {
	private String token;
	
	public Token () {
		this.token = "db5b796ad48a7f5ce090a1e0cd19ad7759685c90";
	}
	
	@Bean
	public String getToken() {
		return token;
	}
	
}
