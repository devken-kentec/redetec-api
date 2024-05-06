package br.com.kentec.redetec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.kentec.redetec.domain.Raca;

public interface RacaRepository extends JpaRepository<Raca, Long>{
	
	@Query("SELECT r FROM Raca r WHERE r.status = 'ATIVO' ")
	List<Raca> selectRacaComboBox();

}
