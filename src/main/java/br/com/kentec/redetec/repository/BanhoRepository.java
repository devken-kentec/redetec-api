package br.com.kentec.redetec.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.kentec.redetec.domain.Banho;

public interface BanhoRepository extends JpaRepository<Banho, Long>{
	
	@Query("SELECT b FROM Banho b WHERE b.status = 'ATIVO' ")
	List<Banho> selectBanhoComboBox();
}
