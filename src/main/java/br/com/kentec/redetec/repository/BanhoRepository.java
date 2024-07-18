package br.com.kentec.redetec.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.kentec.redetec.domain.Banho;

public interface BanhoRepository extends JpaRepository<Banho, Long>{
	
	@Query("SELECT b FROM Banho b WHERE b.status = 'ATIVO' ")
	List<Banho> selectBanhoComboBox();
	
	@Query("SELECT b FROM Banho b WHERE b.status = 'Inativo' ")
	List<Banho> listarBanhoInativo();
	
	@Query("SELECT b FROM Banho b WHERE b.status = 'ATIVO' AND UPPER(b.inicio) LIKE UPPER(:hoje) ")
	List<Banho> listarBanhoDiaAtual(@Param("hoje") String hoje);
	
	@Query("SELECT b FROM Banho b "
			+ "WHERE b.animal.id = :animal "
			+ "AND b.statusPagamentoBanho = :statusPagamentoBanho "
			+ "AND b.status = 'Ativo' ")
	List<Banho> listarBanhoAnimalStatusPagamento(
			@Param("animal") Long animal,
			@Param("statusPagamentoBanho")String statusPagamentoBanho);
	
	@Query("SELECT b FROM Banho b "
			+ "WHERE b.statusPagamentoBanho = :statusPagamentoBanho "
			+ "AND b.status = 'Ativo' ")
	List<Banho> listarBanhoStatusPagamento(@Param("statusPagamentoBanho")String statusPagamentoBanho);
	
	@Query("SELECT b FROM Banho b "
			+ "WHERE UPPER(b.inicio) LIKE UPPER(:data) "
			+ "AND b.status = 'Ativo' ")
	List<Banho> listarBanhoAnimalData(@Param("data") String data);
}
