package br.com.kentec.redetec.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.kentec.redetec.domain.Acesso;
import br.com.kentec.redetec.domain.Login;


public interface AcessoRepository extends JpaRepository<Acesso, Long> {
	
	Optional<Acesso> findByLogin(Login login);
	
	@Query("SELECT a FROM Acesso a WHERE a.login = :login ")
	List<Acesso> findAllLogin(@Param("login") Login login);
	
}
