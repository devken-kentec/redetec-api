package br.com.kentec.redetec.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.kentec.redetec.domain.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
	
	@Query("SELECT a FROM Animal a WHERE a.status = 'ATIVO' ")
	List<Animal> selectAnimalComboBox();
	
	@Query("SELECT a FROM Animal a WHERE UPPER(a.nome) LIKE UPPER(:nome) ")
	Page<Animal> searchName(
			@Param("nome")String nome,
			Pageable pageable);
}
