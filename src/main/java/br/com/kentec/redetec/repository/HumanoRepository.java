package br.com.kentec.redetec.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.kentec.redetec.domain.Humano;

public interface HumanoRepository extends JpaRepository<Humano, Long> {
	
	@Query("SELECT h FROM Humano h WHERE h.status = 'ATIVO' ")
	List<Humano> selectHumanoComboBox();
	
	Optional<Humano> findByEmail(String email);
	
	@Query("SELECT h FROM Humano h WHERE UPPER(h.nome) LIKE UPPER(:nome) ")
	Page<Humano> searchName(
			@Param("nome")String nome,
			Pageable pageable);
}
