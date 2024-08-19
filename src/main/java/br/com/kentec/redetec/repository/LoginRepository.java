package br.com.kentec.redetec.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.kentec.redetec.domain.Humano;
import br.com.kentec.redetec.domain.Login;


public interface LoginRepository extends JpaRepository<Login, Long>{
	
	Optional<Login> findByHumano(Humano humano);
}
