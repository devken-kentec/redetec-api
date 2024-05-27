package br.com.kentec.redetec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.kentec.redetec.domain.TipoBanhoTosa;

public interface TipoBanhoTosaRepository extends JpaRepository<TipoBanhoTosa, Long>{
	
	@Query("SELECT t FROM TipoBanhoTosa t WHERE t.status = 'ATIVO' ")
	List<TipoBanhoTosa> selectTipoBanhoTosaComboBox();
}
