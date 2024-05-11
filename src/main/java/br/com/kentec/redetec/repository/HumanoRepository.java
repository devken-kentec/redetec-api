package br.com.kentec.redetec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.kentec.redetec.domain.Humano;

public interface HumanoRepository extends JpaRepository<Humano, Long> {
	
	@Query("SELECT h FROM Humano h WHERE h.status = 'ATIVO' ")
	List<Humano> selectHumanoComboBox();
}
